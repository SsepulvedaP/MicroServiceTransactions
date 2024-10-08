package com.MicroService.MicroServiceTransaction.domain.usecase;

import com.MicroService.MicroServiceTransaction.domain.api.ISaleServicePort;
import com.MicroService.MicroServiceTransaction.domain.exception.OutOfStockException;
import com.MicroService.MicroServiceTransaction.domain.exception.PurchaseFailedException;
import com.MicroService.MicroServiceTransaction.domain.models.Product;
import com.MicroService.MicroServiceTransaction.domain.models.Sale;
import com.MicroService.MicroServiceTransaction.domain.models.SaleItem;
import com.MicroService.MicroServiceTransaction.domain.spi.*;
import lombok.RequiredArgsConstructor;

import static com.MicroService.MicroServiceTransaction.utils.Constants.*;

@RequiredArgsConstructor
public class SaleUseCase implements ISaleServicePort {

    private final IProductPersistencePort productPersistencePort;
    private final ISalePersistencePort salePersistencePort;
    private final IShoppingCartPersistencePort shoppingCartPersistencePort;
    private final IReportPersistencePort reportPersistencePort;
    private final ISecurityPersistencePort securityPersistencePort;

    @Override
    public Sale createSale(Sale sale, Long userId, String userEmail, String token) {
        try {
            securityPersistencePort.setToken(token);
            sale.setUserId(userId);
            sale.setUserEmail(userEmail);

            validateStockAndAdjust(sale);

             processSaleTransaction(sale);

            removeItemsFromShoppingCart(sale);

            generatePurchaseReport(sale);

            return sale;

        } catch (Exception e) {
            throw new PurchaseFailedException(PURCHASE_FAILED);
        }
    }

    private void validateStockAndAdjust(Sale sale) {
        for (SaleItem saleItem : sale.getSaleItems()) {
            Product product = productPersistencePort.getProductById(saleItem.getProductId());
            if (product.getQuantity() < saleItem.getQuantity()) {
                throw new OutOfStockException(OUT_OF_STOCK);
            }
            int newQuantity = product.getQuantity() - saleItem.getQuantity();
            saleItem.setProductName(product.getName());
            productPersistencePort.reduceProductQuantity(saleItem.getProductId(), newQuantity);
        }
    }

    private Sale processSaleTransaction(Sale sale) {
        sale.setPurchaseDate(java.time.LocalDateTime.now());
        sale.setStatus(SALE_STATUS);
        return salePersistencePort.createSale(sale);
    }

    private void removeItemsFromShoppingCart(Sale sale) {
        for (SaleItem saleItem : sale.getSaleItems()) {
            shoppingCartPersistencePort.deleteProductFromShoppingCart(saleItem.getProductId());
        }
    }

    private void generatePurchaseReport(Sale sale) {
        sale.setUserEmail(sale.getUserEmail());
        reportPersistencePort.generateReport(sale);
    }
}
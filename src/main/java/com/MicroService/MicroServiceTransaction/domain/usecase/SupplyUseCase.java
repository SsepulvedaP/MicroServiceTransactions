package com.MicroService.MicroServiceTransaction.domain.usecase;

import com.MicroService.MicroServiceTransaction.domain.api.ISupplyServicePort;
import com.MicroService.MicroServiceTransaction.domain.exception.WrongQuantity;
import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import com.MicroService.MicroServiceTransaction.domain.spi.IProductPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.spi.ISecurityPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.spi.ISupplyPersistencePort;

import java.time.LocalDateTime;

import static com.MicroService.MicroServiceTransaction.utils.Constants.MIN_QUANTITY;
import static com.MicroService.MicroServiceTransaction.utils.Constants.WRONG_QUANTITY;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;
    private final IProductPersistencePort productPersistencePort;
    private ISecurityPersistencePort securityPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort, IProductPersistencePort productPersistencePort, ISecurityPersistencePort securityPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.productPersistencePort = productPersistencePort;
        this.securityPersistencePort = securityPersistencePort;
    }

    @Override
    public void saveSupply(Supply supply, String token) {

        securityPersistencePort.setToken(token);
        // Verificar si la fecha ya está establecida
        if (supply.getDate() == null) {
            supply.setDate(LocalDateTime.now());
        }

        // Validar la cantidad si es necesario
        if (supply.getQuantity() < MIN_QUANTITY) {
            throw new WrongQuantity(WRONG_QUANTITY);
        }

        supplyPersistencePort.saveSupply(supply);
        productPersistencePort.updateProductQuantity(supply.getProductId(), supply.getQuantity());
    }
}


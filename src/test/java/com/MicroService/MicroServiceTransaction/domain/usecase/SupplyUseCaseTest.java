package com.MicroService.MicroServiceTransaction.domain.usecase;

import com.MicroService.MicroServiceTransaction.domain.exception.WrongQuantity;
import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import com.MicroService.MicroServiceTransaction.domain.spi.IProductPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.spi.ISecurityPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.MicroService.MicroServiceTransaction.utils.Constants.MIN_QUANTITY;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupplyUseCaseTest {


    @Mock
    private ISecurityPersistencePort securityPersistencePort;

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @Mock
    private IProductPersistencePort productPersistencePort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    private Supply supply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        supply = new Supply();
        supply.setProductId(1L);
        supply.setQuantity(10);
    }

    @Test
    void saveSupply_ShouldSaveSupplyAndUpdateProductQuantity_WhenValidSupply() {
        String token = "valid-token";
        doNothing().when(securityPersistencePort).setToken(token);
        supplyUseCase.saveSupply(supply, token);

        // Assert
        verify(securityPersistencePort).setToken(token);
        verify(supplyPersistencePort).saveSupply(supply);
        verify(productPersistencePort).updateProductQuantity(supply.getProductId(), supply.getQuantity());
    }

    @Test
    void saveSupply_ShouldSetDate_WhenSupplyHasNoDate() {
        // Arrange
        String token = "valid-token";
        supply.setDate(null);  // Deja la fecha como nula para que se auto-establezca

        // Act
        supplyUseCase.saveSupply(supply, token);

        // Assert
        assertNotNull(supply.getDate());  // Verifica que la fecha se ha establecido
        verify(supplyPersistencePort).saveSupply(supply);  // Verifica que se guarda el suministro
        verify(productPersistencePort).updateProductQuantity(supply.getProductId(), supply.getQuantity());  // Verifica que se actualiza la cantidad del producto
    }

    @Test
    void saveSupply_ShouldThrowWrongQuantityException_WhenQuantityIsLessThanMin() {
        // Arrange
        String token = "valid-token";
        Supply invalidSupply = new Supply();
        invalidSupply.setQuantity(MIN_QUANTITY - 1);  // Valor menor que la cantidad mínima

        doNothing().when(securityPersistencePort).setToken(token);

        // Act & Assert: Verificamos que se lanza la excepción WrongQuantity
        assertThrows(WrongQuantity.class, () -> supplyUseCase.saveSupply(invalidSupply, token));

        // Verificamos que no se llamaron a los métodos que no deberían ejecutarse si la excepción es lanzada
        verify(supplyPersistencePort, never()).saveSupply(any());
        verify(productPersistencePort, never()).updateProductQuantity(anyLong(), anyInt());
    }


}
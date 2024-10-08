package com.MicroService.MicroServiceTransaction.infrastructure.input.rest;


import com.MicroService.MicroServiceTransaction.application.dto.request.SaleRequest;
import com.MicroService.MicroServiceTransaction.application.dto.response.SaleResponse;
import com.MicroService.MicroServiceTransaction.application.handler.ISaleHandler;
import com.MicroService.MicroServiceTransaction.infrastructure.security.SecurityUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.MicroService.MicroServiceTransaction.utils.Constants.AUTH_TOKEN;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleRestController {

    private final ISaleHandler saleHandler;

    @Operation(summary = "Crear una nueva venta", description = "Permite a un usuario realizar una compra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venta creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la venta incorrectos"),
            @ApiResponse(responseCode = "500", description = "Error en el servidor")
    })
    @PostMapping
    public ResponseEntity<SaleResponse> createSale(@Valid @RequestBody SaleRequest saleRequest,
                                                   @RequestHeader(AUTH_TOKEN) String token) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
        Long userId = userDetails.getId();
        String userEmail = userDetails.getEmail();
        SaleResponse saleResponse = saleHandler.createSale(saleRequest, userId, userEmail, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleResponse);
    }

}
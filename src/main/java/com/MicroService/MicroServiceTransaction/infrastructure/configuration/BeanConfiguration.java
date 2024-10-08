package com.MicroService.MicroServiceTransaction.infrastructure.configuration;

import com.MicroService.MicroServiceTransaction.domain.api.ISaleServicePort;
import com.MicroService.MicroServiceTransaction.domain.api.ISupplyServicePort;
import com.MicroService.MicroServiceTransaction.domain.spi.*;
import com.MicroService.MicroServiceTransaction.domain.usecase.SaleUseCase;
import com.MicroService.MicroServiceTransaction.domain.usecase.SupplyUseCase;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ProductFeignClient;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ReportFeignClient;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ShoppingCartFeignClient;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter.*;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper.SaleEntityMapper;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper.SupplyEntityMapper;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository.ISaleRepository;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository.ISupplyRepository;
import com.MicroService.MicroServiceTransaction.infrastructure.security.SecurityAdapter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;
    private final ISaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;
    private final ProductFeignClient productFeignClient;
    private final UserDetailsService userDetailsService;
    private final ShoppingCartFeignClient shoppingCartFeignClient;
    private final ReportFeignClient reportFeignClient;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISalePersistencePort salePersistencePort() {
        return new SaleJpaAdapter(saleRepository, saleEntityMapper);
    }

    @Bean
    public IProductPersistencePort productPersistencePort() {
        return new ProductJpaAdapter(productFeignClient);
    }


    @Bean
    public IReportPersistencePort reportPersistencePort() {
        return new ReportFeignAdapter(reportFeignClient);
    }

    @Bean
    public IShoppingCartPersistencePort shoppingCartPersistencePort() {
        return new ShoppingCartFeignAdapter(shoppingCartFeignClient);
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort(), productPersistencePort(), securityPersistencePort());
    }

    @Bean
    @Transactional  // Para garantizar consistencia en la operación de compra
    public ISaleServicePort saleServicePort() {
        return new SaleUseCase(productPersistencePort(), salePersistencePort(), shoppingCartPersistencePort(), reportPersistencePort(), securityPersistencePort());
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public ISecurityPersistencePort securityPersistencePort() {
        return new SecurityAdapter();
    }
}


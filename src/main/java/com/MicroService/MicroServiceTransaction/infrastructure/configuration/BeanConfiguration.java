package com.MicroService.MicroServiceTransaction.infrastructure.configuration;

import com.MicroService.MicroServiceTransaction.domain.api.ISupplyServicePort;
import com.MicroService.MicroServiceTransaction.domain.spi.IProductPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.spi.ISecurityPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.spi.ISupplyPersistencePort;
import com.MicroService.MicroServiceTransaction.domain.usecase.SupplyUseCase;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ProductFeignClient;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter.ProductJpaAdapter;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter.SupplyJpaAdapter;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper.SupplyEntityMapper;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository.ISupplyRepository;
import com.MicroService.MicroServiceTransaction.infrastructure.security.SecurityAdapter;
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
    private final ProductFeignClient productFeignClient;
    private final UserDetailsService userDetailsService;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }


    @Bean
    public IProductPersistencePort productPersistencePort() {
        return new ProductJpaAdapter(productFeignClient);
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort(), productPersistencePort(), securityPersistencePort());
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

package com.MicroService.MicroServiceTransaction.infrastructure.feign.configuration;

import com.MicroService.MicroServiceTransaction.infrastructure.security.SecurityAdapter;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.MicroService.MicroServiceTransaction.utils.Constants.AUTH_TOKEN;

@Component
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {

    private final SecurityAdapter securityAdapter;

    @Override
    public void apply(RequestTemplate template) {
        String token = securityAdapter.getToken();

        if (token != null && !token.isEmpty()) {
            template.header(AUTH_TOKEN, token);
        }
    }
}

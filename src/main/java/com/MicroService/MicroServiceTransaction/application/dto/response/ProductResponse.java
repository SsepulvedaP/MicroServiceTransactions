package com.MicroService.MicroServiceTransaction.application.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String name;
    private String description;
    private int quantity;
}
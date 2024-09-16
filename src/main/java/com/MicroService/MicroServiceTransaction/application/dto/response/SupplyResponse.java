package com.MicroService.MicroServiceTransaction.application.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyResponse {
    private Long id;
    private Long productId;
    private int quantity;

}

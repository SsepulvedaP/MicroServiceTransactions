package com.MicroService.MicroServiceTransaction.domain.spi;

import com.MicroService.MicroServiceTransaction.domain.models.Sale;

public interface IReportPersistencePort {
    void generateReport(Sale sale);
}

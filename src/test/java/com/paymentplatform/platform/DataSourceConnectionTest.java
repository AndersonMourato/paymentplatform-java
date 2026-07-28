package com.paymentplatform.platform;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DataSourceConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void shouldLoadDataSourceBean() {
        assertNotNull(dataSource);
    }
}

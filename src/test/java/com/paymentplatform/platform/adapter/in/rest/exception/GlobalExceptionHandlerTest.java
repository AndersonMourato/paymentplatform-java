package com.paymentplatform.platform.adapter.in.rest.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @Test
    void shouldBuildApiErrorResponseRecord() {
        ApiErrorResponse response = new ApiErrorResponse(
                java.time.OffsetDateTime.now(),
                400,
                "Validation Error",
                "Invalid payload",
                "/users"
        );

        assertEquals(400, response.status());
        assertEquals("Validation Error", response.error());
    }
}

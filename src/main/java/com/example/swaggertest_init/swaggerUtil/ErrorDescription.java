package com.example.swaggertest_init.swaggerUtil;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Hidden
@Data
@RequiredArgsConstructor
public class ErrorDescription {
    @Schema(
            description = "HTTP Status Code",
            example = "404"
    )
    private String errorCode;

    @Schema(
            description = "Error description",
            example = "Product is not exist in database"
    )
    private String errorDescription;
}

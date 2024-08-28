package com.dl_users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PhoneDto {
    @Schema(
            description = "Correo electrónico del usuario",
            example = "123456"
    )
    private String number;
    @Schema(
            description = "Correo electrónico del usuario",
            example = "9"
    )
    private String cityCode;
    @Schema(
            description = "Correo electrónico del usuario",
            example = "+56"
    )
    private String countryCode;
}
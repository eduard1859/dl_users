package com.dl_users.dto.request;

import com.dl_users.dto.PhoneDto;
import com.dl_users.validator.ValidPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    @Schema(
            description = "Correo electrónico del usuario",
            example = "carlos eduardo"
    )
    private String name;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener un formato válido")
    @Schema(
            description = "Correo electrónico del usuario",
            example = "usuario@dominio.com"
    )
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "El correo debe tener un formato válido"

    )
    private String email;

    @Schema(
            description = "Contraseña del usuario. Debe contener al menos una letra minúscula, una letra mayúscula, un dígito, un carácter especial, y tener una longitud mínima de 8 caracteres.",
            example = "P@ssw0rd!"
    )
    @ValidPassword(message = "La contraseña debe cumplir con los requisitos de seguridad")
    @NotEmpty(message = "Password es requerido")
    private String password;

    private List<PhoneDto> phones;


}

package org.example.domacirozpocet2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username nesmí být null")
    @NotBlank(message = "username nesmí být prázdné")
    @NotEmpty(message = "username nesmí být prázdný")
    private String name;
    @Email(message = "špatná emailová adresa")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "špatný zadaný tel.")
    private String mobile;
}
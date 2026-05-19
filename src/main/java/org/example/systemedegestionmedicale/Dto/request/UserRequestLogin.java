package org.example.systemedegestionmedicale.Dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestLogin {
    @NotBlank(message = "username est obligatoire")
    private String username;
    @NotBlank(message = "password est obligatoire")
    private String password ;
}

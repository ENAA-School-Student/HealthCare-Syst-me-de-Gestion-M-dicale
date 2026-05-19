package org.example.systemedegestionmedicale.Dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "username est obligatoire")
    private String username;
    @NotBlank(message = "email est obligatoire")
    private String email;
    @NotBlank(message = "password est obligatoire")
    private String password ;
}

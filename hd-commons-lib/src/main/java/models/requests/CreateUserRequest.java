package models.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.With;
import models.enums.ProfileEnum;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@With
public record CreateUserRequest(
                                @Schema(description = "User email",example = "Rafael Roco")
                                @NotEmpty(message = "Name cannot be empty")
                                @Size(min=3,max=50,message = "Name must contain between 3 and 50 characters")
                                String name,

                                @Schema(description = "User E-mail", example = "rafael@gmail.com")
                                @Email(message = "Invalid E-mail")
                                @NotBlank(message = "E-mail cannot by empty")
                                @Size(min=6,max=50,message = "E-mail must contain between 3 and 50 characters")
                                String email,

                                @Schema(description = "User password", example = "123456")
                                @Size(min=3,max=50,message = "Password must contain between 3 and 50 characters")
                                @NotBlank(message = "Password cannot by empty")
                                String password,

                                @Schema(description = "User profiles", example = "[\"ROLE_ADMIN\", \"ROLE_CUSTOMER\"]")
                                Set<ProfileEnum> profile
)implements Serializable {

    @Serial
    private static final long serialVersionUUID = 1L;

}

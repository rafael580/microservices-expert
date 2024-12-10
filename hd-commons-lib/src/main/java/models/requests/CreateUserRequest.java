package models.requests;

import lombok.With;
import models.enums.ProfileEnum;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@With
public record CreateUserRequest(
                                String name,
                                String email,
                                String password,
                                Set<ProfileEnum> profile
)implements Serializable {

    @Serial
    private static final long serialVersionUUID = 1L;

}

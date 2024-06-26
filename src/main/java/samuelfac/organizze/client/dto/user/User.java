package samuelfac.organizze.client.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(
        Long id,
        String name,
        String email,
        String role
) {
}

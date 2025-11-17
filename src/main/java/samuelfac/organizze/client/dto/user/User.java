package samuelfac.organizze.client.dto.user;

import lombok.Builder;

@Builder
public record User(
        Long id,
        String name,
        String email,
        String role
) {
    public static final class Fields {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String ROLE = "role";

        private Fields() {} // prevent instantiation
    }
}

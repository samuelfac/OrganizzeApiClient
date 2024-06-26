package samuelfac.organizze.client.dto.user;

public record User(
        Long id,
        String name,
        String email,
        String role
) {
}

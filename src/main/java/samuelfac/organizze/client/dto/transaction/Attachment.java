package samuelfac.organizze.client.dto.transaction;

public record Attachment(String url) {
    public static final class Fields {
        public static final String URL = "url";

        private Fields() {} // prevent instantiation
    }
}

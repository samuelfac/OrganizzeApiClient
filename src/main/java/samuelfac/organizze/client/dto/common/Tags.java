package samuelfac.organizze.client.dto.common;

import lombok.Builder;

@Builder
public record Tags(String name) {
    public static final class Fields {
        public static final String NAME = "name";

        private Fields() {} // prevent instantiation
    }
}

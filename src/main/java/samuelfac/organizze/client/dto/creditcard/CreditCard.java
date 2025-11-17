package samuelfac.organizze.client.dto.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

@Builder
public record CreditCard(
        Long id,
        String name,
        String description,
        @JsonProperty("card_network") String cardNetwork,
        @JsonProperty("closing_day") Integer closingDay,
        @JsonProperty("due_day") Integer dueDay,
        @JsonProperty("limit_cents") Integer limitCents,
        Boolean archived,
        @JsonProperty("default") Boolean _default,
        @JsonProperty("institution_id") String institutionId,
        @JsonProperty("institution_name") String institutionName,
        @JsonProperty("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime createdAt,
        @JsonProperty("updated_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime updatedAt,
        String type,
        Boolean deleted
) {
    public static final class Fields {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String CARD_NETWORK = "card_network";
        public static final String CLOSING_DAY = "closing_day";
        public static final String DUE_DAY = "due_day";
        public static final String LIMIT_CENTS = "limit_cents";
        public static final String ARCHIVED = "archived";
        public static final String DEFAULT = "default";
        public static final String INSTITUTION_ID = "institution_id";
        public static final String INSTITUTION_NAME = "institution_name";
        public static final String CREATED_AT = "created_at";
        public static final String UPDATED_AT = "updated_at";
        public static final String TYPE = "type";
        public static final String DELETED = "deleted";

        private Fields() {} // prevent instantiation
    }
}

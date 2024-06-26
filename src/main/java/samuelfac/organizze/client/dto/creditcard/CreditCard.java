package samuelfac.organizze.client.dto.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

@Builder
@FieldNameConstants
public record CreditCard(
        @FieldNameConstants.Exclude Long id,
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
        @JsonProperty("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @FieldNameConstants.Exclude ZonedDateTime createdAt,
        @JsonProperty("updated_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @FieldNameConstants.Exclude ZonedDateTime updatedAt,
        String type,
        Boolean deleted
) {
}

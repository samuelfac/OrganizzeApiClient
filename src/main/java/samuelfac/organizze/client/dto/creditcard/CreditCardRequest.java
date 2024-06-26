package samuelfac.organizze.client.dto.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CreditCardRequest(
        String name,
        @JsonProperty("card_network") String cardNetwork,
        @JsonProperty("due_day") Integer dueDay,
        @JsonProperty("closing_day") Integer closingDay,
        @JsonProperty("limit_cents") Integer limitCents

) {
}

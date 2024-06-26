package samuelfac.organizze.client.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record AccountRequest(String name,
                             String type,
                             String description,
                             @JsonProperty("default") Boolean _default
) {
}

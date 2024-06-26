package samuelfac.organizze.client.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record TransactionDeleteRequest(
        @JsonProperty("update_future") Boolean updateFuture
) {
}

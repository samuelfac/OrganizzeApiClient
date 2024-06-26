package samuelfac.organizze.client.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record InstallmentsAttribute(
        Periodicity periodicity,
        Integer total
) {

}

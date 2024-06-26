package samuelfac.organizze.client.dto.transaction;

import lombok.Builder;

@Builder
public record InstallmentsAttribute(
        Periodicity periodicity,
        Integer total
) {

}

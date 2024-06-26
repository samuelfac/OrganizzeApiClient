package samuelfac.organizze.client.dto.categorie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CategorieDeleteRequest(
        @JsonProperty(value = "replacement_id", required = true) Long replacementId
) {
}

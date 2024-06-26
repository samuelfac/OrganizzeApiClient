package samuelfac.organizze.client.dto.categorie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CategorieRequest(
        String name,
        String color,
        @JsonProperty("parent_id") Long parentId
) {
}

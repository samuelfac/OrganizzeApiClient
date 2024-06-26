package samuelfac.organizze.client.dto.categorie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;

@Builder
@FieldNameConstants
public record Categorie(
        @FieldNameConstants.Exclude Long id,
        String name,
        String color,
        @JsonProperty("parent_id") Long parentId,
        @JsonProperty("group_id") String groupId,
        Boolean fixed,
        Boolean essential,
        @JsonProperty("default") Boolean _default,
        @FieldNameConstants.Exclude String uuid,
        String kind,
        Boolean archived,
        Boolean deleted
) {
}

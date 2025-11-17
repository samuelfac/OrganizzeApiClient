package samuelfac.organizze.client.dto.categorie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Categorie(
        Long id,
        String name,
        String color,
        @JsonProperty("parent_id") Long parentId,
        @JsonProperty("group_id") String groupId,
        Boolean fixed,
        Boolean essential,
        @JsonProperty("default") Boolean _default,
        String uuid,
        String kind,
        Boolean archived,
        Boolean deleted
) {
    public static final class Fields {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String COLOR = "color";
        public static final String PARENT_ID = "parent_id";
        public static final String GROUP_ID = "group_id";
        public static final String FIXED = "fixed";
        public static final String ESSENTIAL = "essential";
        public static final String DEFAULT = "default";
        public static final String UUID = "uuid";
        public static final String KIND = "kind";
        public static final String ARCHIVED = "archived";
        public static final String DELETED = "deleted";

        private Fields() {} // prevent instantiation
    }
}

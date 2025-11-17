package samuelfac.organizze.client.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

@Builder
public record Account(Long id,
                      String name,
                      @JsonProperty("institution_id") String institutionId,
                      @JsonProperty("institution_name") String institutionName,
                      String description,
                      String kind,
                      Boolean archived,
                      @JsonProperty("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime createdAt,
                      @JsonProperty("updated_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime updatedAt,
                      @JsonProperty("default") Boolean _default,
                      String type,
                      String balance,
                      Boolean deleted
) {
    public static final class Fields {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String INSTITUTION_ID = "institution_id";
        public static final String INSTITUTION_NAME = "institution_name";
        public static final String DESCRIPTION = "description";
        public static final String KIND = "kind";
        public static final String ARCHIVED = "archived";
        public static final String CREATED_AT = "created_at";
        public static final String UPDATED_AT = "updated_at";
        public static final String DEFAULT = "default";
        public static final String TYPE = "type";
        public static final String BALANCE = "balance";
        public static final String DELETED = "deleted";

        private Fields() {} // prevent instantiation
    }

}

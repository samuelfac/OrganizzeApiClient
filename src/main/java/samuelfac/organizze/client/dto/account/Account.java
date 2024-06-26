package samuelfac.organizze.client.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

@Builder
@FieldNameConstants
public record Account(@FieldNameConstants.Exclude Long id,
                      String name,
                      @JsonProperty("institution_id") String institutionId,
                      @JsonProperty("institution_name") String institutionName,
                      String description,
                      Boolean archived,
                      @JsonProperty("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime createdAt,
                      @JsonProperty("updated_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime updatedAt,
                      @JsonProperty("default") Boolean _default,
                      String type,
                      String balance,
                      Boolean deleted
) {


}

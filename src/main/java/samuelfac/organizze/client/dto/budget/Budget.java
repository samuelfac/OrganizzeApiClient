package samuelfac.organizze.client.dto.budget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
public record Budget(
        @JsonProperty("amount_in_cents") Integer amountInCents,
        @JsonProperty("category_id") Long categoryId,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @JsonProperty("activity_type") Integer activityType,
        Integer total,
        @JsonProperty("predicted_total") Integer predictedTotal,
        String percentage

) {
}

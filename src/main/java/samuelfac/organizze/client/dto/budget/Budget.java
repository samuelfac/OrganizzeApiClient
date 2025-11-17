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
    public static final class Fields {
        public static final String AMOUNT_IN_CENTS = "amount_in_cents";
        public static final String CATEGORY_ID = "category_id";
        public static final String DATE = "date";
        public static final String ACTIVITY_TYPE = "activity_type";
        public static final String TOTAL = "total";
        public static final String PREDICTED_TOTAL = "predicted_total";
        public static final String PERCENTAGE = "percentage";

        private Fields() {} // prevent instantiation
    }
}

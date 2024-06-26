package samuelfac.organizze.client.dto.creditcard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import samuelfac.organizze.client.dto.transaction.Transaction;

import java.time.LocalDate;
import java.util.List;

@Builder
public record Invoice(
        Long id,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @JsonProperty("starting_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startingDate,
        @JsonProperty("closing_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate closingDate,
        @JsonProperty("amount_cents") Integer amountCents,
        @JsonProperty("payment_amount_cents") Integer paymentAmountCents,
        @JsonProperty("balance_cents") Integer balanceCents,
        @JsonProperty("previous_balance_cents") Integer previousBalanceCents,
        @JsonProperty("credit_card_id") Long creditCardId,
        List<Transaction> transactions,
        List<Transaction> payments
) {
}

package samuelfac.organizze.client.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import samuelfac.organizze.client.dto.common.Tags;

import java.time.LocalDate;
import java.util.List;

@Builder
public record TransactionRequest(
        String description,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        Boolean paid,
        @JsonProperty("amount_cents") Integer amountCents,
        @JsonProperty("account_id") Long accountId,
        @JsonProperty("category_id") Long categoryId,
        @JsonProperty("credit_card_id") Long creditCardId,
        @JsonProperty("credit_card_invoice_id") Long creditCardInvoiceId,
        @JsonProperty("paid_credit_card_id") Long paidCreditCardId,
        @JsonProperty("paid_credit_card_invoice_id") Long paidCreditCardInvoiceId,
        @JsonProperty("oposite_transaction_id") Long opositeTransactionId,
        @JsonProperty("oposite_account_id") Long opositeAccountId,
        List<Tags> tags,
        List<Attachment> attachments,
        @JsonProperty("recurrence_attributes") RecurrenceAttribute recurrenceAttributes,
        @JsonProperty("installments_attributes") InstallmentsAttribute installmentsAttributes
) {
}

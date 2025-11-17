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
        String notes,
        List<Tags> tags,
        List<Attachment> attachments,
        @JsonProperty("recurrence_attributes") RecurrenceAttribute recurrenceAttributes,
        @JsonProperty("installments_attributes") InstallmentsAttribute installmentsAttributes
) {
    public static final class Fields {
        public static final String DESCRIPTION = "description";
        public static final String DATE = "date";
        public static final String PAID = "paid";
        public static final String AMOUNT_CENTS = "amount_cents";
        public static final String ACCOUNT_ID = "account_id";
        public static final String CATEGORY_ID = "category_id";
        public static final String CREDIT_CARD_ID = "credit_card_id";
        public static final String CREDIT_CARD_INVOICE_ID = "credit_card_invoice_id";
        public static final String PAID_CREDIT_CARD_ID = "paid_credit_card_id";
        public static final String PAID_CREDIT_CARD_INVOICE_ID = "paid_credit_card_invoice_id";
        public static final String OPPOSITE_TRANSACTION_ID = "oposite_transaction_id";
        public static final String OPPOSITE_ACCOUNT_ID = "oposite_account_id";
        public static final String NOTES = "notes";
        public static final String TAGS = "tags";
        public static final String ATTACHMENTS = "attachments";
        public static final String RECURRENCE_ATTRIBUTES = "recurrence_attributes";
        public static final String INSTALLMENTS_ATTRIBUTES = "installments_attributes";

        private Fields() {} // prevent instantiation
    }
}

package samuelfac.organizze.client.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import samuelfac.organizze.client.dto.common.Tags;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Builder
public record Transaction(
        Long id,
        String description,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        Boolean paid,
        @JsonProperty("amount_cents") Integer amountCents,
        @JsonProperty("total_installments") Integer totalInstallments,
        Integer installment,
        Boolean recurring,
        @JsonProperty("account_id") Long accountId,
        @JsonProperty("category_id") Long categoryId,
        String notes,
        @JsonProperty("account_type") String accountType,
        @JsonProperty("attachments_count") Integer attachmentsCount,
        @JsonProperty("credit_card_id") Long creditCardId,
        @JsonProperty("credit_card_invoice_id") Long creditCardInvoiceId,
        @JsonProperty("paid_credit_card_id") Long paidCreditCardId,
        @JsonProperty("paid_credit_card_invoice_id") Long paidCreditCardInvoiceId,
        @JsonProperty("oposite_transaction_id") Long opositeTransactionId,
        @JsonProperty("oposite_account_id") Long opositeAccountId,
        @JsonProperty("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime createdAt,
        @JsonProperty("updated_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime updatedAt,
        @JsonProperty("tags") @JsonDeserialize(using = TagsListDeserializer.class) List<Tags> tags,
        List<Attachment> attachments,
        @JsonProperty("recurrence_id") Long recurrenceId,
        Boolean deleted
) {

    public static final class Fields {
        public static final String ID = "id";
        public static final String DESCRIPTION = "description";
        public static final String DATE = "date";
        public static final String PAID = "paid";
        public static final String AMOUNT_CENTS = "amount_cents";
        public static final String TOTAL_INSTALLMENTS = "total_installments";
        public static final String INSTALLMENT = "installment";
        public static final String RECURRING = "recurring";
        public static final String ACCOUNT_ID = "account_id";
        public static final String CATEGORY_ID = "category_id";
        public static final String NOTES = "notes";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String ATTACHMENTS_COUNT = "attachments_count";
        public static final String CREDIT_CARD_ID = "credit_card_id";
        public static final String CREDIT_CARD_INVOICE_ID = "credit_card_invoice_id";
        public static final String PAID_CREDIT_CARD_ID = "paid_credit_card_id";
        public static final String PAID_CREDIT_CARD_INVOICE_ID = "paid_credit_card_invoice_id";
        public static final String OPPOSITE_TRANSACTION_ID = "oposite_transaction_id";
        public static final String OPPOSITE_ACCOUNT_ID = "oposite_account_id";
        public static final String CREATED_AT = "created_at";
        public static final String UPDATED_AT = "updated_at";
        public static final String TAGS = "tags";
        public static final String ATTACHMENTS = "attachments";
        public static final String RECURRENCE_ID = "recurrence_id";
        public static final String DELETED = "deleted";

        private Fields() {} // prevent instantiation
    }

}

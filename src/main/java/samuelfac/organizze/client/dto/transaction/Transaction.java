package samuelfac.organizze.client.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import samuelfac.organizze.client.dto.common.Tags;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Builder
@FieldNameConstants
public record Transaction(
        @FieldNameConstants.Exclude Long id,
        String description,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        Boolean paid,
        @JsonProperty("amount_cents") Integer amountCents,
        @JsonProperty("total_installments") @FieldNameConstants.Exclude Integer totalInstallments,
        Integer installment,
        Boolean recurring,
        @JsonProperty("account_id") Long accountId,
        @JsonProperty("category_id") Long categoryId,
        String notes,
        @JsonProperty("account_type") String accountType,
        @JsonProperty("attachments_count") @FieldNameConstants.Exclude Integer attachmentsCount,
        @JsonProperty("credit_card_id") Long creditCardId,
        @JsonProperty("credit_card_invoice_id") Long creditCardInvoiceId,
        @JsonProperty("paid_credit_card_id") Long paidCreditCardId,
        @JsonProperty("paid_credit_card_invoice_id") Long paidCreditCardInvoiceId,
        @JsonProperty("oposite_transaction_id") Long opositeTransactionId,
        @JsonProperty("oposite_account_id") Long opositeAccountId,
        @JsonProperty("created_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @FieldNameConstants.Exclude ZonedDateTime createdAt,
        @JsonProperty("updated_at") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @FieldNameConstants.Exclude ZonedDateTime updatedAt,
        @JsonProperty("tags") @JsonDeserialize(using = TagsListDeserializer.class) List<Tags> tags,
        List<Attachment> attachments,
        @JsonProperty("recurrence_id") Long recurrenceId,
        Boolean deleted
) {


}

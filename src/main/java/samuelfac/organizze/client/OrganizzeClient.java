package samuelfac.organizze.client;

import jakarta.annotation.Nonnull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import samuelfac.organizze.client.dto.account.Account;
import samuelfac.organizze.client.dto.account.AccountRequest;
import samuelfac.organizze.client.dto.budget.Budget;
import samuelfac.organizze.client.dto.categorie.Categorie;
import samuelfac.organizze.client.dto.categorie.CategorieDeleteRequest;
import samuelfac.organizze.client.dto.categorie.CategorieRequest;
import samuelfac.organizze.client.dto.creditcard.CreditCard;
import samuelfac.organizze.client.dto.creditcard.CreditCardRequest;
import samuelfac.organizze.client.dto.creditcard.Invoice;
import samuelfac.organizze.client.dto.transaction.Transaction;
import samuelfac.organizze.client.dto.transaction.TransactionDeleteRequest;
import samuelfac.organizze.client.dto.transaction.TransactionRequest;
import samuelfac.organizze.client.dto.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@HttpExchange(url = "https://api.organizze.com.br/rest/v2", accept = "application/json; charset=utf-8")
public interface OrganizzeClient {

    @GetExchange("/users")
    List<User> getAllUsers();

    @GetExchange("/users/{userId}")
    User getUser(@PathVariable Long userId);


    @GetExchange("/accounts")
    List<Account> getAllAccounts();

    @GetExchange("/accounts/{accountId}")
    Account getAccount(@PathVariable Long accountId);

    @PostExchange("/accounts")
    Account createAccount(@RequestBody AccountRequest accountRequest);

    @PutExchange("/accounts/{accountId}")
    Account updateAccount(@PathVariable Long accountId,
                          @RequestBody Map<String, Object> values);

    @DeleteExchange("/accounts/{accountId}")
    Account deleteAccount(@PathVariable Long accountId);


    @GetExchange("/budgets")
    List<Budget> getAllBudgets();


    @GetExchange("/categories")
    List<Categorie> getAllCategories();

    @GetExchange("/categories/{categorieId}")
    Categorie getCategorie(@PathVariable Long categorieId);

    @PostExchange("/categories")
    Categorie createCategorie(@RequestBody CategorieRequest categorieRequest);

    @PutExchange("/categories/{categorieId}")
    Categorie updateCategorie(@PathVariable Long categorieId,
                              @RequestBody Map<String, Object> values);

    @DeleteExchange("/categories/{categorieId}")
    Categorie deleteCategorie(@PathVariable Long categorieId,
                              @RequestBody @Nonnull CategorieDeleteRequest categorieDeleteRequest);


    @GetExchange("/credit_cards")
    List<CreditCard> getAllCreditCards();

    @GetExchange("/credit_cards/{creditCardId}")
    CreditCard getCreditCard(@PathVariable Long creditCardId);

    @PostExchange("/credit_cards")
    CreditCard createCreditCard(@RequestBody CreditCardRequest creditCardsRequest);

    @PutExchange("/credit_cards/{creditCardId}")
    CreditCard updateCreditCard(@PathVariable Long creditCardId,
                                @RequestBody Map<String, Object> values);

    @DeleteExchange("/credit_cards/{creditCardId}")
    CreditCard deleteCreditCard(@PathVariable Long creditCardId);


    @GetExchange("/credit_cards/{creditCardId}/invoices")
    List<Invoice> getAllInvoices(@PathVariable Long creditCardId,
                                 @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                 @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetExchange("/credit_cards/{creditCardId}/invoices/{invoiceId}")
    Invoice getInvoice(@PathVariable Long creditCardId,
                       @PathVariable Long invoiceId);


    @GetExchange("/credit_cards/{creditCardId}/invoices/{invoiceId}/payments")
    List<Transaction> getInvoicePayments(@PathVariable Long creditCardId,
                                         @PathVariable Long invoiceId,
                                         @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                         @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);


    @GetExchange("/transactions")
    List<Transaction> getAllTransactions(
            @RequestParam(value = "account_id", required = false) Long accountId,
            @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetExchange("/transactions/{id}")
    Transaction getTransaction(
            @PathVariable Long id,
            @RequestParam(value = "account_id", required = false) Long accountId,
            @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @PostExchange("/transactions")
    Transaction createTransaction(@RequestBody TransactionRequest transactionRequest);

    @PutExchange("/transactions/{id}")
    Transaction updateTransaction(@PathVariable Long id,
                                  @RequestBody Map<String, Object> values);

    @DeleteExchange("/transactions/{id}")
    Transaction deleteTransaction(@PathVariable Long id,
                                  @RequestBody TransactionDeleteRequest transactionDeleteRequest);
}

package samuelfac.organizze.client;

import jakarta.annotation.Nonnull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import samuelfac.organizze.client.config.FeignConfig;
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

@FeignClient(name = "organizze", url = "https://api.organizze.com.br/rest/v2", configuration = FeignConfig.class)
public interface OrganizzeClient {

    @GetMapping("/users")
    List<User> getAllUsers();

    @GetMapping("/users/{userId}")
    User getUser(@PathVariable Long userId);


    @GetMapping("/accounts")
    List<Account> getAllAccounts();

    @GetMapping("/accounts/{accountId}")
    Account getAccount(@PathVariable Long accountId);

    @PostMapping("/accounts")
    Account createAccount(@RequestBody AccountRequest accountRequest);

    @PutMapping("/accounts/{accountId}")
    Account updateAccount(@PathVariable Long accountId,
                          @RequestBody Map<String, Object> values);

    @DeleteMapping("/accounts/{accountId}")
    Account deleteAccount(@PathVariable Long accountId);


    @GetMapping("/budgets")
    List<Budget> getAllBudgets();


    @GetMapping("/categories")
    List<Categorie> getAllCategories();

    @GetMapping("/categories/{categorieId}")
    Categorie getCategorie(@PathVariable Long categorieId);

    @PostMapping("/categories")
    Categorie createCategorie(@RequestBody CategorieRequest categorieRequest);

    @PutMapping("/categories/{categorieId}")
    Categorie updateCategorie(@PathVariable Long categorieId,
                              @RequestBody Map<String, Object> values);

    @DeleteMapping("/categories/{categorieId}")
    Categorie deleteCategorie(@PathVariable Long categorieId,
                              @RequestBody @Nonnull CategorieDeleteRequest categorieDeleteRequest);


    @GetMapping("/credit_cards")
    List<CreditCard> getAllCreditCards();

    @GetMapping("/credit_cards/{creditCardId}")
    CreditCard getCreditCard(@PathVariable Long creditCardId);

    @PostMapping("/credit_cards")
    CreditCard createCreditCard(@RequestBody CreditCardRequest creditCardsRequest);

    @PutMapping("/credit_cards/{creditCardId}")
    CreditCard updateCreditCard(@PathVariable Long creditCardId,
                                @RequestBody Map<String, Object> values);

    @DeleteMapping("/credit_cards/{creditCardId}")
    CreditCard deleteCreditCard(@PathVariable Long creditCardId);


    @GetMapping("/credit_cards/{creditCardId}/invoices")
    List<Invoice> getAllInvoices(@PathVariable Long creditCardId,
                                 @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                 @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping("/credit_cards/{creditCardId}/invoices/{invoiceId}")
    Invoice getInvoice(@PathVariable Long creditCardId,
                       @PathVariable Long invoiceId);


    @GetMapping("/credit_cards/{creditCardId}/invoices/{invoiceId}/payments")
    List<Transaction> getInvoicePayments(@PathVariable Long creditCardId,
                                         @PathVariable Long invoiceId,
                                         @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                         @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);


    @GetMapping("/transactions")
    List<Transaction> getAllTransactions(
            @RequestParam(value = "account_id", required = false) Long accountId,
            @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping("/transactions/{id}")
    Transaction getTransaction(
            @PathVariable Long id,
            @RequestParam(value = "account_id", required = false) Long accountId,
            @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @PostMapping("/transactions")
    Transaction createTransaction(@RequestBody TransactionRequest transactionRequest);

    @PutMapping("/transactions/{id}")
    Transaction updateTransaction(@PathVariable Long id,
                                  @RequestBody Map<String, Object> values);

    @DeleteMapping("/transactions/{id}")
    Transaction deleteTransaction(@PathVariable Long id,
                                  @RequestBody TransactionDeleteRequest transactionDeleteRequest);
}

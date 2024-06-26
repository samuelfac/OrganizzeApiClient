package samuelfac.organizze.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import samuelfac.organizze.client.config.FeignConfig;
import samuelfac.organizze.client.dto.account.AccountRequest;
import samuelfac.organizze.client.dto.categorie.CategorieDeleteRequest;
import samuelfac.organizze.client.dto.categorie.CategorieRequest;
import samuelfac.organizze.client.dto.creditcard.CreditCardRequest;
import samuelfac.organizze.client.dto.transaction.InstallmentsAttribute;
import samuelfac.organizze.client.dto.transaction.Periodicity;
import samuelfac.organizze.client.dto.transaction.Transaction;
import samuelfac.organizze.client.dto.transaction.TransactionDeleteRequest;
import samuelfac.organizze.client.dto.transaction.TransactionRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest(classes = TestConfig.class)
@EnableFeignClients
@AutoConfigureWebClient
@Import(FeignConfig.class)
class OrganizzeClientTest {


    @Autowired
    OrganizzeClient client;

    @Test
    void testGetAllUsers() {
        var allUsers = client.getAllUsers();
        assertNotNull(allUsers);
        var user = client.getUser(allUsers.stream().findAny().get().id());
        assertNotNull(user);
    }

    @Test
    void testAccountOperations() {
        var account = client.createAccount(new AccountRequest("TESTE", "checking", "Account Test", false));
        assertNotNull(account);

        account = client.getAccount(account.id());
        assertNotNull(account);

        var allAccounts = client.getAllAccounts();
        assertNotNull(allAccounts);

        Map<String, Object> accountValues = new HashMap<>();
        accountValues.put("name", "TEST changed");
        account = client.updateAccount(account.id(), accountValues);
        assertNotNull(account);

        account = client.deleteAccount(account.id());
        assertNotNull(account);
    }


    @Test
    void testGetAllBudgets() {
        var allBudgets = client.getAllBudgets();
        assertNotNull(allBudgets);
    }

    @Test
    void testCategoryOperations() {
        var categorie = client.createCategorie(CategorieRequest.builder().name("test").build());
        assertNotNull(categorie);

        categorie = client.getCategorie(categorie.id());
        assertNotNull(categorie);

        var allCategories = client.getAllCategories();
        assertNotNull(allCategories);

        Map<String, Object> categorieValues = new HashMap<>();
        categorieValues.put("name", "Test CHANGED");
        categorie = client.updateCategorie(categorie.id(), categorieValues);
        assertNotNull(categorie);

        categorie = client.deleteCategorie(categorie.id(), new CategorieDeleteRequest(allCategories.stream().findFirst().get().id()));
        assertNotNull(categorie);
    }

    @Test
    void testCreditCardOperations() {
        var allCreditCards = client.getAllCreditCards();
        assertNotNull(allCreditCards);//

        var creditCard = client.getCreditCard(allCreditCards.stream().filter(c -> !c.archived()).findAny().get().id());
        assertNotNull(creditCard);

        var invoices = client.getAllInvoices(creditCard.id(), null, null);
        assertNotNull(invoices);

        var invoice = client.getInvoice(creditCard.id(), invoices.stream().findAny().get().id());
        assertNotNull(invoice);

        var payments = client.getInvoicePayments(invoice.creditCardId(), invoice.id(), null, null);
        assertNotNull(payments);

        creditCard = client.createCreditCard(new CreditCardRequest("test", "visa", 1, 1, 1000));
        assertNotNull(creditCard);

        Map<String, Object> creditCardValues = new HashMap<>();
        creditCardValues.put("name", "Test Changed");
        creditCard = client.updateCreditCard(creditCard.id(), creditCardValues);
        assertNotNull(creditCard);

        creditCard = client.deleteCreditCard(creditCard.id());
        assertNotNull(creditCard);
    }

    @Test
    void testTransactionOperations() {


        var transaction = client.createTransaction(TransactionRequest.builder()
                .description("TEST")
                .amountCents(-1)
                .date(LocalDate.now())
                .paid(true)
                .accountId(client.getAllAccounts().stream().findAny().get().id())
                .categoryId(client.getAllCategories().stream().findAny().get().id())
                .installmentsAttributes(InstallmentsAttribute.builder().periodicity(Periodicity.monthly).total(1).build())
                .build());
        assertNotNull(transaction);

        transaction = client.getTransaction(transaction.id(), null, null, null);
        assertNotNull(transaction);

        var allTransactions = client.getAllTransactions(null, null, null);
        assertNotNull(allTransactions);//

        Map<String, Object> transactionValues = new HashMap<>();
        transactionValues.put(Transaction.Fields.description, "TEST Changed");
        transaction = client.updateTransaction(transaction.id(), transactionValues);
        assertNotNull(transaction);

        transaction = client.deleteTransaction(transaction.id(), TransactionDeleteRequest.builder().updateFuture(false).build());
        assertNotNull(transaction);
    }


}
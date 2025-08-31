package nevg.banktask.Entity;

import jakarta.persistence.*;
import nevg.banktask.Entity.Enum.Currency;
import nevg.banktask.Entity.Enum.Status;
import nevg.banktask.Entity.Enum.Type;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    @Column(name = "type_transactions", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type typeTransaction;

    @Column(name = "from_account", nullable = false)
    private String fromAccount;

    @Column(name = "to_account", nullable = false)
    private String toAccount;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(0)")
    private LocalDateTime createdAt;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "reference")
    private String reference;

    @ManyToOne
    private Account account;

    public Transaction() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Type getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(Type typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

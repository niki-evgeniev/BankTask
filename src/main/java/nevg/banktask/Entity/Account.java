package nevg.banktask.Entity;


import jakarta.persistence.*;
import nevg.banktask.Entity.Enum.AccountStatus;
import nevg.banktask.Entity.Enum.Currency;
import nevg.banktask.Entity.Enum.Status;

import java.math.BigDecimal;

@Table
@Entity(name = "account")
public class Account extends BaseEntity {

    @Column(name = "iban", unique = true, nullable = false)
    private String iban;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToOne
    private User user;

    @Version
    private int version;

    public Account() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
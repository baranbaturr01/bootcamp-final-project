package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_policy_id", insertable = false, updatable = false)
    private CustomerPolicy customer_policy;

    @Column(name = "amount")
    private int amount;
    @Column(name = "payment_date")
    private String payment_date;

    public Payment(int id, CustomerPolicy customerPolicy, int amount, String payment_date) {
        this.id = id;
        this.customer_policy = customerPolicy;
        this.amount = amount;
        this.payment_date = payment_date;
    }

    public Payment() {
    }

    public int getPayment_id() {
        return id;
    }

    public void setPayment_id(int payment_id) {
        this.id = payment_id;
    }

    public CustomerPolicy getCustomerPolicy() {
        return customer_policy;
    }

    public void setCustomerPolicy(CustomerPolicy customerPolicy) {
        this.customer_policy = customerPolicy;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
}

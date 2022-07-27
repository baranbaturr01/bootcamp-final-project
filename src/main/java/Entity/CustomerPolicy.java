package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_policy")
public class CustomerPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "policy_id", insertable = false, updatable = false)
    private Policy policy;

    @ManyToOne
    @JoinColumn(name = "agency_id", insertable = false, updatable = false)
    private Agency agency;
    @Column(name = "start_date")
    private String start_date;
    @Column(name = "insurance_amount")
    private int insurance_amount;

    public CustomerPolicy() {
    }

    public CustomerPolicy(int id, Customer customer, Policy policy, Agency agency, String start_date, int insurance_amount) {
        this.id = id;
        this.customer = customer;
        this.policy = policy;
        this.agency = agency;
        this.start_date = start_date;
        this.insurance_amount = insurance_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency_id(Agency agency) {
        this.agency = agency;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getInsurance_amount() {
        return insurance_amount;
    }

    public void setInsuranceAmount(int insurance_amount) {
        this.insurance_amount = insurance_amount;
    }
}

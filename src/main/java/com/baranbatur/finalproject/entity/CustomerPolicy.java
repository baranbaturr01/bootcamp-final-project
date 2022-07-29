package com.baranbatur.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

}

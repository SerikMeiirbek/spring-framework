package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="payments")
@NoArgsConstructor
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }
}

package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="payment_details")
@NoArgsConstructor
@Data
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal merchant_payout_amount;
    private BigDecimal commissionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail", cascade=CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public PaymentDetail(BigDecimal merchant_payout_amount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchant_payout_amount = merchant_payout_amount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}

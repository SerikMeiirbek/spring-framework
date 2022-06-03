package com.cydeo.entity;

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

    private BigDecimal commissionAmount;
    private BigDecimal merchantPayoutAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail")
    @JoinColumn(name="payment_id")
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commission_amount, LocalDate payoutDate) {
        this.commissionAmount = commission_amount;
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.payoutDate = payoutDate;
    }
}

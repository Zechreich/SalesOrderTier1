package org.ait.project.boardingtest.modules.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity(name = "transaction_history")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_customer", nullable = false)
    private Long idCustomer;

    @Column(name = "id_product", nullable = false)
    private Long idProduct;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price")
    private BigInteger totalPrice;

    @Column(name = "bank_transfer_number")
    private String bankTransferNumber;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

}

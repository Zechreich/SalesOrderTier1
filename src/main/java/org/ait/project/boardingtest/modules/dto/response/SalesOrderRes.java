package org.ait.project.boardingtest.modules.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class SalesOrderRes {

    @JsonProperty("idTransaction")
    private Long idTransaction;

    @JsonProperty("idCustomer")
    private Long idCustomer;

    @JsonProperty("namaCustomer")
    private String namaCustomer;

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("productCategory")
    private String productCategory;

    @JsonProperty("namaProduct")
    private String namaProduct;

    @JsonProperty("price")
    private BigInteger price;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("bankTransferNumber")
    private String bankTransferNumber;

    @JsonProperty("totalPrice")
    private BigInteger totalPrice;

}

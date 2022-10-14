package org.ait.project.boardingtest.modules.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@Data
public class SalesOrderReq {

    @JsonProperty("idCustomer")
    @NotBlank(message = "Wajib input nomor id customer")
    private Long idCustomer;

    @JsonProperty("idProduct")
    @NotBlank(message = "Wajib input nomor id product")
    private Long idProduct;

    @JsonProperty("quantity")
    @NotBlank(message = "Tidak boleh null")
    private Integer quantity;

    @JsonProperty("bankTransferNumber")
    @NotBlank(message = "Masukan bukti nomor resi bank")
    private String bankTransferNumber;

    @JsonProperty("totalPrice")
    @NotBlank(message = "Tidak boleh null")
    private BigInteger totalPrice;

}
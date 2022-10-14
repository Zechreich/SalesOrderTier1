package org.ait.project.boardingtest.modules.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class SalesAccumulateRes {

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("productCategory")
    private String productCategory;

    @JsonProperty("namaProduct")
    private String namaProduct;

    @JsonProperty("totalSold")
    private Integer totalSold;

    @JsonProperty("totalRevenue")
    private BigInteger totalRevenue;

}

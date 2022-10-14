package org.ait.project.boardingtest.modules.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.math.BigInteger;

@Data
public class ProductRes {

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("productCategory")
    private String productCategory;

    @JsonProperty("namaProduct")
    private String namaProduct;

    @JsonProperty("pricePerUnit")
    private BigInteger pricePerUnit;

    @JsonProperty("stock")
    private Integer stock;
}

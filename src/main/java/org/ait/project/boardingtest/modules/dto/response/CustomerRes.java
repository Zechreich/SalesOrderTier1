package org.ait.project.boardingtest.modules.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerRes {

    @JsonProperty("idCustomer")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

}

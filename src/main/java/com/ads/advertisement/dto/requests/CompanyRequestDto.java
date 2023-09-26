package com.ads.advertisement.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDto {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    @JsonProperty("company_type")
    private String companyType;

    @NotBlank
    @NotNull
    @JsonProperty("additional_information")
    private String additionalInformation;

    @NotBlank
    @NotNull
    @JsonProperty("image_link")
    private String imageLink;

    @NotBlank
    @NotNull
    @Min(value = 0, message = "Value must be at least {value}")
    @JsonProperty("products_count")
    private Integer productsCount;

    @NotBlank
    @NotNull
    @JsonProperty("phone_list")
    private List<Map<String, String>> phoneList;
}

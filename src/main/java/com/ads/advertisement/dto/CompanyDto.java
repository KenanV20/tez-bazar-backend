package com.ads.advertisement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private Long id;

    private String name;

    private String address;

    @JsonProperty("company_type")
    private String companyType;

    @JsonProperty("additional_information")
    private String additionalInformation;

    @JsonProperty("image_link")
    private String imageLink;

    @JsonProperty("products_count")
    private Integer productsCount;

    @JsonProperty("phone_list")
    private List<Map<String,String>> phoneList;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

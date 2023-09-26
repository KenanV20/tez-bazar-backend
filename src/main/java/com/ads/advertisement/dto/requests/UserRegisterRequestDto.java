package com.ads.advertisement.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDto {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("phone_number_one")
    private String phoneNumberOne;
    private String email;
    private String password;
    private String gender;
}

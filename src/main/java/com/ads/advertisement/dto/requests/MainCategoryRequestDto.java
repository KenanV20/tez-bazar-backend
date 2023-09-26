package com.ads.advertisement.dto.requests;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class MainCategoryRequestDto {

    @NotBlank(message = "Name may not be null or empty")
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters long")
    String name;
    String icon;
}

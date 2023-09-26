package com.ads.advertisement.controller;

import com.ads.advertisement.annotations.ExistsInDatabase;
import com.ads.advertisement.dto.CompanyDto;
import com.ads.advertisement.dto.SimpleMessageDto;
import com.ads.advertisement.dto.requests.CompanyRequestDto;
import com.ads.advertisement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/companies")
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping
    public CompanyDto addCompany(
            @RequestBody CompanyRequestDto companyRequestDto
    ) {
        return companyService.addCompany(companyRequestDto);
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyById(
            @ExistsInDatabase(table = "companies", column = "id",message = "This company category not found")
            @PathVariable Long id
    ) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public CompanyDto updateCompany(
            @ExistsInDatabase(table = "companies", column = "id",message = "This company category not found")
            @PathVariable Long id,
            @RequestBody CompanyRequestDto companyRequestDto
    ) {
        return companyService.updateCompany(id,companyRequestDto);
    }
}

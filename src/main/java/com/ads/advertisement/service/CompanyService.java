package com.ads.advertisement.service;

import com.ads.advertisement.dao.entity.CompanyEntity;
import com.ads.advertisement.dao.entity.UserEntity;
import com.ads.advertisement.dao.repository.CompanyRepository;
import com.ads.advertisement.dao.repository.UserRepository;
import com.ads.advertisement.dto.CompanyDto;
import com.ads.advertisement.dto.SimpleMessageDto;
import com.ads.advertisement.dto.requests.CompanyRequestDto;
import com.ads.advertisement.mapper.CompanyMapper;
import com.ads.advertisement.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    public CompanyDto addCompany(CompanyRequestDto companyRequestDto) {
        log.info("ActionLog.start addCompany, companyRequestDto: {}", companyRequestDto);
        CompanyEntity companyEntity = CompanyMapper.INSTANCE.dtoToEntity(companyRequestDto);
        CompanyEntity companyResponseEntity = companyRepository.save(companyEntity);

        UserEntity userEntity = AuthService.getUser();
        userEntity.setCompanyEntity(companyResponseEntity);
        userRepository.save(userEntity);
        CompanyDto companyDto = CompanyMapper.INSTANCE.entityToDto(companyResponseEntity);
        log.info("ActionLog.end addCompany, response companyDto: {}", companyDto);
        return companyDto;
    }

    public CompanyDto getCompanyById(Long id) {
        return CompanyMapper.INSTANCE.entityToDto(companyRepository.findById(id).get());
    }

    public CompanyDto updateCompany(Long id, CompanyRequestDto companyRequestDto) {
        log.info("ActionLog.start updateCompany, companyRequestDto: {}, id: {}", companyRequestDto, id);
        CompanyEntity companyEntity = companyRepository.findById(id).get();
        BeanUtils.copyProperties(companyRequestDto, companyEntity);
        CompanyDto companyDto = CompanyMapper.INSTANCE.entityToDto(companyRepository.save(companyEntity));
        log.info("ActionLog.end updateCompany, companyRequestDto: {}, id: {}", companyRequestDto, id);
        return companyDto;
    }
}

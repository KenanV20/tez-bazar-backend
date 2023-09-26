package com.ads.advertisement.validations;

import com.ads.advertisement.annotations.ExistsInDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsInDatabaseValidator implements ConstraintValidator<ExistsInDatabase, Long> {
    private String table;
    private String column;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void initialize(ExistsInDatabase constraintAnnotation) {
        this.table = constraintAnnotation.table();
        this.column = constraintAnnotation.column();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String sql = "SELECT COUNT(*) FROM " + table + " WHERE " + column + " = :value";
        MapSqlParameterSource parameters = new MapSqlParameterSource("value", value);
        int count = namedParameterJdbcTemplate.queryForObject(sql, parameters, Integer.class);
        return count > 0;
    }
}
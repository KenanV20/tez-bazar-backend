package com.ads.advertisement.validations;

import com.ads.advertisement.annotations.WordCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WordCountValidator implements ConstraintValidator<WordCount, String> {
    private int minWordCount;

    @Override
    public void initialize(WordCount constraintAnnotation) {
        minWordCount = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        String[] words = value.trim().split("\\s+");
        return words.length >= minWordCount;
    }
}

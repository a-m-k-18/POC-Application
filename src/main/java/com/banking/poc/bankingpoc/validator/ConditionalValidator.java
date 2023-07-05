package com.banking.poc.bankingpoc.validator;

import com.banking.poc.bankingpoc.validator.Conditional;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Arrays;

import static org.springframework.util.ObjectUtils.isEmpty;


    @Slf4j
    public class ConditionalValidator implements ConstraintValidator<Conditional, Object> {

        private String selected;
        private String[] required;
        private String message;
        private String[] values;

        @Override
        public void initialize(Conditional requiredIfChecked) {
            selected = requiredIfChecked.selected();
            required = requiredIfChecked.required();
            message = requiredIfChecked.message();
            values = requiredIfChecked.values();
        }

        @Override
        public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
            Boolean valid = true;
            BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(objectToValidate);
            Object actualValue = beanWrapper.getPropertyValue(selected);
            if (Arrays.asList(values).contains(actualValue)) {
                for (String propName : required) {
                    BeanWrapper beanWrapper1=PropertyAccessorFactory.forBeanPropertyAccess(objectToValidate);
                    Object requiredValue = beanWrapper1.getPropertyValue(propName);
                    valid = requiredValue != null && !isEmpty(requiredValue);
                    System.out.println("value: " + "" + requiredValue);
                    if (!valid) {
                        context.disableDefaultConstraintViolation();
                        context.buildConstraintViolationWithTemplate(message).addPropertyNode(propName).addConstraintViolation();
                    }
                }
            }
            return valid;
        }
    }


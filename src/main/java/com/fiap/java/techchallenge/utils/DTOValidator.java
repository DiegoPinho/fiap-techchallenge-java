package com.fiap.java.techchallenge.utils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class DTOValidator {

  @Autowired
  Validator validator;

  public <T> Map<Object, Object> check(T dto) {
    Set<ConstraintViolation<T>> violacoes = validator.validate(dto);
    Map<Object, Object> collect = violacoes.stream()
        .collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));

    return collect;
  }

}

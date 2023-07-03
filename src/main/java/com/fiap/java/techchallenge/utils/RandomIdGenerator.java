package com.fiap.java.techchallenge.utils;

import java.util.Random;

public class RandomIdGenerator {

  private static final Random GENERATOR = new Random();

  private RandomIdGenerator() {
    throw new IllegalStateException("Utility class");
  }

  public static Integer generateId() {
    return GENERATOR.nextInt(Integer.MAX_VALUE);
  }

}

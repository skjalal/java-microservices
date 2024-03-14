package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;

class ServiceRegistryApplicationTest {

  @Test
  void testMain() {
    assertEquals("3.2.3", SpringBootVersion.getVersion());
  }
}

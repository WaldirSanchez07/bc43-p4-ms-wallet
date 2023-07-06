package com.nttdata.mswallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main class.
 */
@SpringBootApplication
@EnableEurekaClient
public class WalletApplication {

  public static void main(String[] args) {
    SpringApplication.run(WalletApplication.class, args);
  }

}

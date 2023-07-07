package com.nttdata.mswallet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Send notification by kafka.
 */
@FeignClient(name = "kafka-service", path = "kafka", url = "localhost:9000")
public interface FeignKafka {

  @PostMapping("/publish")
  void sendKafkaMessage(@RequestParam("message") String message);

}

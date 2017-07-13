package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 可以通过启动多个eureka-client服务来观察其负载均衡的效果
 */
@RestController
public class DcController {

  private final RestTemplate restTemplate;

  /**
   * 等同于之前 test-eureka-client @GetMapping("/consumer") 接口中的代码
   * @return 返回test-eureka-client 中@GetMapping("/dc")所返回的内容
   */
  @GetMapping("/consumer")
  public String dc(){
    return restTemplate.getForObject("http://test-eureka-client/dc",String.class);
  }

  @Autowired
  public DcController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
}

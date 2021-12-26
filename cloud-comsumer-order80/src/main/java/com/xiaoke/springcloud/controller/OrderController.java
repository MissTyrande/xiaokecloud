package com.xiaoke.springcloud.controller;

import com.xiaoke.springcloud.entities.CommonResult;
import com.xiaoke.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "consumer/create")
    public CommonResult create(@RequestBody Payment payment) {
        CommonResult result = restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
        return result;
    }

    @GetMapping(value = "consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id) {
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
        return result;
    }
}

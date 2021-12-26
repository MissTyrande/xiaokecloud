package com.xiaoke.springcloud.controller;

import com.xiaoke.springcloud.entities.CommonResult;
import com.xiaoke.springcloud.entities.Payment;
import com.xiaoke.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("开始插入{}", payment.getId());
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(400, "插入失败", null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("开始查询{}", id);
        if (ObjectUtils.isEmpty(result)) {
            return new CommonResult(400, "查询失败", id);
        } else {
            return new CommonResult(200, "查询成功", result);
        }
    }
}

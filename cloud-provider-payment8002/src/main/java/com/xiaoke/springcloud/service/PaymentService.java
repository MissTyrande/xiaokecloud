package com.xiaoke.springcloud.service;

import com.xiaoke.springcloud.dao.PaymentDao;
import com.xiaoke.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

}

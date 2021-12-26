package com.xiaoke.springcloud.dao;

import com.xiaoke.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int create(@Param("payment") Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}

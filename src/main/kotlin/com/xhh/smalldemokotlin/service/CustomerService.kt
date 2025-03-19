package com.xhh.smalldemokotlin.service

import com.xhh.smalldemokotlin.domain.CustomerEntity
import org.springframework.stereotype.Service

@Service
class CustomerService {

    fun findAll(): MutableList<CustomerEntity> {
        return mutableListOf()
    }
}
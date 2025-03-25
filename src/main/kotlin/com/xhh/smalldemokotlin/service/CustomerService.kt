package com.xhh.smalldemokotlin.service

import com.xhh.smalldemokotlin.domain.CustomerEntity
import com.xhh.smalldemokotlin.module.ResultVO
import com.xhh.smalldemokotlin.repository.CustomerEntityRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerService(
    private val customerEntityRepository: CustomerEntityRepository
) {

    fun findAll(): List<CustomerEntity>? {
        return customerEntityRepository.findAllByStatus(1)
    }

    fun findFirstById(id: Long): CustomerEntity? {
        return customerEntityRepository.findFirstById(id)
    }

    @Transactional
    fun save(customer: CustomerEntity): CustomerEntity {
        return customerEntityRepository.save(customer)
    }

    @Transactional
    fun update(id: Long, customer: CustomerEntity): CustomerEntity? {
        return customerEntityRepository.findById(id).map { existingCustomer ->
            customer.id = id
            customerEntityRepository.save(customer)
        }.orElse(null)
    }

    @Transactional
    fun deleteById(id: Long) {
        customerEntityRepository.deleteById(id)
    }
}
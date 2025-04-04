package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.domain.CustomerEntity
import com.xhh.smalldemokotlin.module.ResultVO
import com.xhh.smalldemokotlin.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.CollectionUtils
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @GetMapping
    fun getAllCustomers(): ResultVO {
        val resultVO = ResultVO(1, "success")
        val customers = customerService.findAll()
        
        if (!CollectionUtils.isEmpty(customers)) {
            resultVO.result["list"] = customers
        }
        
        resultVO.result["list"] = customers
        return resultVO
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable(name = "id") id: Long): ResultVO {
        val customer = customerService.findFirstById(id)
        if (customer != null) {
            return ResultVO().success(customer.toMap())
        }
        
        return ResultVO()
    }

    @PostMapping
    fun createCustomer(@RequestBody(required = false) customer: CustomerEntity?): ResponseEntity<CustomerEntity> {
        val c = CustomerEntity(null, "customer.name", 20, 1)
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(c))
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: CustomerEntity): ResponseEntity<CustomerEntity> {
        val updatedCustomer = customerService.update(id, customer)
        return if (updatedCustomer != null) {
            ResponseEntity.ok(updatedCustomer)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long): ResponseEntity<Unit> {
        val customer = customerService.findFirstById(id)
        return if (customer != null) {
            customerService.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
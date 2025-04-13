package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.domain.CustomerEntity
import com.xhh.smalldemokotlin.module.ResultVO
import com.xhh.smalldemokotlin.service.CustomerService
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
    fun createCustomer(@RequestBody(required = false) customer: CustomerEntity?): ResultVO {
        val c = CustomerEntity(null, "customer.name", 20, 1)
        customerService.save(c)
        return ResultVO().success(mutableMapOf("id" to c.id))
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: CustomerEntity): ResultVO {
        val updatedCustomer = customerService.update(id, customer)

        return ResultVO().success(mutableMapOf("id" to id))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long): ResultVO {
        val customer = customerService.findFirstById(id)
        val resultVO = ResultVO()
        if (customer == null) {
            resultVO.status = 0
            resultVO.message = "employee not exists"
        } else {
            customer.status = 0
            customerService.save(customer)
            resultVO.status = 1
            resultVO.message = "success"
        }

        return resultVO
    }
}
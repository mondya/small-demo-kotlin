package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.module.ResultVO
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    
    
    fun index() : ResultVO {
        return ResultVO()
    }
}
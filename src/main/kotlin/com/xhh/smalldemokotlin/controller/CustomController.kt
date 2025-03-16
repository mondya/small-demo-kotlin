package com.xhh.smalldemokotlin.controller

import com.xhh.smalldemokotlin.domain.Custom

class CustomController {
    
    fun index() {
        val custom = Custom(id = 1, name = "xhh", age = 18)
    }
}
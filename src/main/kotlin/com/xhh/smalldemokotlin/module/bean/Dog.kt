package com.xhh.smalldemokotlin.module.bean


open class Dog {
    
    var name: String? = null
    
    var age: Int? = null
    
    
    constructor(name: String?, age: Int?) {
        this.name = name
        this.age = age
    }
}
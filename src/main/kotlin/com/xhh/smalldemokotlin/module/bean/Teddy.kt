package com.xhh.smalldemokotlin.module.bean

class Teddy(name: String?, age: Int?) :Dog(name, age) {
    
    var color: String? = null
    
    constructor(name: String?, age: Int, color: String?) : this(name, age) {
        this.color = color
    }
}
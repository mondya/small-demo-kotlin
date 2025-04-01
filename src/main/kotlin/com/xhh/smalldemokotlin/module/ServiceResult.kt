package com.xhh.smalldemokotlin.module

data class ServiceResult<T>(
    var success: Boolean?,
    var message: String?,
    var result: T?
) {
    constructor() : this(null, null, null)


    fun success(result: T?): ServiceResult<T> {
        this.success = true
        this.message = "success"
        this.result = result
        return this
    }

    fun fail(message: String?): ServiceResult<T> {
        this.success = false
        this.message = message
        this.result = null
        return this
    }
}

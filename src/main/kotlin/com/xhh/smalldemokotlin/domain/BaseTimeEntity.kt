package com.xhh.smalldemokotlin.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.util.Date

@MappedSuperclass
abstract class BaseTimeEntity(
    @Column
    open var dateCreated: Date,
    @Column
    open var lastUpdated: Date
) {

    @PrePersist
    fun prePersist() {
        this.dateCreated = Date()
        this.lastUpdated = Date()
    }
    
    @PreUpdate
    fun preUpdated() {
        this.lastUpdated = Date()
    }

}

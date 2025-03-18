package com.xhh.smalldemokotlin.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "customer")
class CustomerEntity {
    @Id
    var id: Long? = null
    
    @Column(name = "name")
    var name: String? = null
    
    var age: Int? = null
    
    var status: Int? = null
}

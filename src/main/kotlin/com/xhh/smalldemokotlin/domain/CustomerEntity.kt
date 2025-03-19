package com.xhh.smalldemokotlin.domain

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "customer")
class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long?,

    @Column(name = "name")
    @Basic
    var name: String?,

    @Basic
    @Column(name = "age")
    var age: Int?,

    @Basic
    @Column
    var status: Int?
) : BaseTimeEntity() {
    // JPA 需要的无参构造函数
    constructor() : this(null, null, null, null)

    constructor(
        id: Long?,
        name: String?,
        age: Int?,
        status: Int?,
        dateCreated: LocalDateTime?,
        lastUpdated: LocalDateTime?
    ) : this()
}
    


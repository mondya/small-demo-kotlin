package com.xhh.smalldemokotlin.domain

import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "customer")
@DynamicInsert
@DynamicUpdate
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CustomerEntity) return false

        // 比较父类属性
        if (dateCreated != other.dateCreated) return false
        if (lastUpdated != other.lastUpdated) return false

        // 比较当前类属性
        if (id != other.id) return false
        if (name != other.name) return false
        if (age != other.age) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (age ?: 0)
        result = 31 * result + (status ?: 0)
        result = 31 * result + dateCreated.hashCode()
        result = 31 * result + lastUpdated.hashCode()
        return result
    }

    override fun toString(): String {
        return "CustomerEntity(id=$id, name=$name, age=$age, status=$status, dateCreated=$dateCreated, lastUpdated=$lastUpdated)"
    }
    
    fun toMap(): MutableMap<String, Any> {
        val map = mutableMapOf<String, Any>()
        this.id?.let { 
            map["id"] = it
        }
        
        this.name?.let { 
            map["name"] = it
        }
        
        this.age?.let { 
            map["age"] = it
        }
        return map
    }
}
    


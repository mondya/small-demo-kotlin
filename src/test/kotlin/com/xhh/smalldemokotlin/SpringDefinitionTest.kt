package com.xhh.smalldemokotlin

import org.junit.Test
import org.springframework.beans.MutablePropertyValues
import org.springframework.beans.factory.support.RootBeanDefinition
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringDefinitionTest {
    
    
    @Test
    fun testDefinition() {
        val rootBeanDefinition = RootBeanDefinition()
        rootBeanDefinition.beanClassName = "com.xhh.smalldemokotlin.module.bean.Dog"

        val mutablePropertyValues = MutablePropertyValues()
        mutablePropertyValues.addPropertyValue("name", "dog")
    }
}
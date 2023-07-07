package com.example.demo.service

import com.example.demo.model.HelloResponse
import org.springframework.stereotype.Service

@Service
class HelloService {
    fun get(): HelloResponse {
        val temp = HelloResponse(id = 1L, name = "Alen")
        println(temp)
        return temp
    }
}
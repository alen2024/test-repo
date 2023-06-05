package com.example.demo.controller

import com.example.demo.model.HelloResponse
import com.example.demo.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("hello")
@RestController
class HelloController(private val helloService: HelloService) {
    @GetMapping
    fun getAllPlayers(): HelloResponse = helloService.get()
}
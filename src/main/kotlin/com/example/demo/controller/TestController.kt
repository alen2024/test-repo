package com.example.demo.controller

import com.example.demo.service.TestService
import jakarta.servlet.http.HttpServletResponse
import kotlinx.coroutines.*
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("testabc")
@Controller
class TestController(
    val testService: TestService
) {
    @GetMapping
    fun index(): String = "/custom/test"

    @GetMapping("/111")
    fun index1(res: HttpServletResponse) = GlobalScope.launch {
        println("a")
        val temp = withContext(Dispatchers.IO) {
            println("b")
            delay(500)
            "abc"
        }
        println("c")
        val temp1 = temp
        temp1
        res.sendRedirect(temp1)
    }

    @GetMapping("/222")
    fun index3(res: HttpServletResponse) = runBlocking {
        println("a")
        val temp = testService.getURI()
        withContext(Dispatchers.IO) {
            println("c")
            res.sendRedirect(temp.substring(0, 12))
        }
    }
}
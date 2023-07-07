package com.example.demo.controller

import kotlinx.coroutines.*
import java.util.concurrent.Executors

class CoroutineTest {
    fun coroutine() {
        val pool = Executors.newFixedThreadPool(64).asCoroutineDispatcher()
        val companyIdList = (0..1000L).shuffled().take(800)
        var count = 1
        val time1 = System.currentTimeMillis()
        val result = runBlocking {
            companyIdList.chunked(80).mapIndexed { index, longs ->
                println("Current Loop Start:${index}")
                longs.map { num ->
                    async {
                        delay(300)
                        println(count)
                        count++
                        println("Current Thread:${Thread.currentThread().name}")
                        CoroutineModel(num)
                    }
                }.awaitAll()
            }
//                longs.map { num ->
//                    withContext(Dispatchers.IO) {
//                        println(count)
//                        count++
//                        println("Current Thread:${Thread.currentThread().id}")
//                        CoroutineModel(num)
//                    }
//                }
        }.flatten()
        println(result)
        println(result.size)
        println("execute time: ${System.currentTimeMillis() - time1}")
    }
}

fun main() {
    CoroutineTest().coroutine()
}

data class CoroutineModel(
    val id: Long
)
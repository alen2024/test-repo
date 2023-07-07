package com.example.demo.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class TestService {
    suspend fun getURI(): String {
        val temp = CoroutineScope(IO).async {
            withContext(Dispatchers.Default) {
                println("b")
                return@withContext "/testabc/222/abc"
            }
        }
        return temp.await()
    }

}
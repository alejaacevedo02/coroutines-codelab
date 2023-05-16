package com.example.android.advancedcoroutines.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch {
            makeFlow().collect { value ->
                println("got $value")
            }
            println("flow is completed")
        }
        launch{
            val repeatableFlow = makeFlow().take(2)
            println("first collection")
            repeatableFlow.collect()
            println("collecting again")
            repeatableFlow.collect()
            println("second collection completed")
        }
    }
}

fun makeFlow() = flow {
    println("sending first value")
    emit(1)
    println("first value collected, sending another value")
    emit(2)
    println("second value collected, sending a third value")
    emit(3)
    println("done")
}


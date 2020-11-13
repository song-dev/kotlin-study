package com.song.kotlin.basics

import org.junit.Test

class InlineTest {

    private val list = listOf(1, 2, 3)

    @Test
    fun let_test() {
        val let = list?.let {
            println(it)
            3
        }
        println(let)

        val run = list?.run {
            println(this.toString())
            4
        }
        println(run)
    }

    @Test
    fun with_test(){
        val with = with(list) {
            this.forEach {
                println(it)
            }
            8
        }
        println(with)
    }

    @Test
    fun apply_test(){
        val apply = list?.apply {
            println(this)
        }
        println(apply)
        val also = list?.also {
            println(it)
        }
        println("also: $also")
    }

}
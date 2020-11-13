package com.song.kotlin.basics

import androidx.constraintlayout.solver.widgets.Rectangle
import org.junit.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * 语法
 */
class GrammarTest {

    @Test
    fun fun_test() {
        println("sum: ${sum(1, 9)}")
        println("abs: ${abs()}")
        println("max: ${max(8, 5)}")
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun abs(x: Int = -100) = if (x > 0) {
        x
    } else {
        -x
    }

    private fun max(a: Int, b: Int) = if (a > b) a else b

    @Test
    fun for_test() {
        val list = listOf("1", "2", "3")
        for (i in list) {
            println(i)
        }
        for (i in list.indices) {
            println(list[i])
        }
        println("describe: ${describe(1234)}")
        for (x in 9 downTo 0 step 3) {
            print(x)
        }
    }

    private fun describe(obj: Any) =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    @Test
    fun lambda_test() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
            .also { println("end: $it") }
    }

    @Test
    fun if_test() {
        val files = File("Test").listFiles()
        println(files?.size ?: "empty")
        println(files?.firstOrNull() ?: "empty")
        files?.let {
            println(files.size)
        }
        println(files?.let { it.size } ?: 10)
        intArrayOf()
            .apply {
                fill(-1)
            }
            .forEach { println(it) }
    }

    @Test
    fun with_test() {
        val myRectangle = Rectangle().apply {
            this.x = 4
            y = 5
        }
        val stream =
            Files.newInputStream(Paths.get("/Users/chensongsong/git_work/kotlin-study/app/src/test/java/com/song/kotlin/ExampleUnitTest.kt"))
//        stream.buffered().reader().use { reader ->
//            println(reader.readText())
//        }
        stream.buffered().reader().apply {
            println(readText())
        }
        var a = 1
        var b = 2
        a = b.also { b = a }
        println("$a , $b")
    }

}


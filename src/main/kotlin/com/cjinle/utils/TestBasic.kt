package com.cjinle.utils

import java.util.Random

class TestBasic {
    fun run() {
        println("test basic...")
//        _runOther()
//        _runCase()
//        RandNum().gen()
        RandNum.gen()
        RandNum.gen2()

        _runObject()


    }

    fun _runObject() {
        val level = 1
        var vipLevel = object {
            var Lv1: Int = level
            var Lv2: Int = level shl 1
            var Lv3: Int = level shl 2
        }

        println("lv1: ${vipLevel.Lv1}, lv2: ${vipLevel.Lv2}, lv3: ${vipLevel.Lv3}")

        MyUtils.hello("kotlin")

    }

    fun _runOther() {
        val (x, y, z) = arrayOf(1,2,3)
        println("$x,$y,$z")
    }

    fun _runCase() {
        cases("Hello")
        cases(1)
        cases(0L)
        cases(MyClass())
        cases("hello")
    }

    fun _runLoops() {
        _for()
        _ranges()
        _eq()

        println(max(99, 10))
    }

    fun _runData() {
        val user = User("Alex", 1)
        println(user)

        val secondUser = User("Alex", 1)
        val thirdUser = User("Max", 2)

        println("user == secondUser: ${user == secondUser}")
        println("user == thirdUser: ${user == thirdUser}")

        // hashCode() function
        println(user.hashCode())
        println(secondUser.hashCode())
        println(thirdUser.hashCode())

        // copy() function
        println(user.copy())
        println(user === user.copy())
        println(user.copy(name = "Max"))
        println(user.copy(id = 3))

        println("name = ${user.component1()}")
        println("id = ${user.component2()}")
    }

    fun _runEnum() {
        val state = State.RUNNING
        val message  = when(state) {
            State.IDLE -> "idle"
            State.RUNNING -> "running"
            State.FINISHED -> "finished"
        }

        println("state: $message")
    }


    fun cases(obj: Any) {
        when(obj) {
            1 -> println("One")
            "Hello" -> println("Greeting")
            is Long -> println("Long")
            !is String -> println("Not a string")
            else -> println("Unknown")
        }
    }

    fun _for() {
        val cakes = listOf<String>("carrot", "cheese", "chocolate")

        for (cake in cakes) {
            println("cake: $cake")
        }
    }

    fun _ranges() {
        for (i in 0..3) print(i)

        println()

        for (i in 0 until  3) print(i)

        println()

        for (i in 2..8 step 2) print(i)

        println()

        for (i in 3 downTo 0) print(i)

        println()
    }

    fun _eq() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")

        println(authors == writers)   // 1
        println(authors === writers)  // 2
    }

    fun max(a: Int, b: Int) = if (a > b) a else b
}

class MyClass

enum class State {
    IDLE, RUNNING, FINISHED
}

data class User(val name: String, val id: Int) {
    override fun equals(other: Any?) =
        other is User && other.id == this.id
}

class RandNum {
    fun gen() {
        var rand = Random()
        for (i in 1..10) {
            print("${rand.nextInt()} ")

        }
//        println(Random().nextInt())
    }

    companion object {
        fun gen() {
            println(Random().nextInt())
        }

        fun gen2() {
            println(Random().nextInt())
        }
    }
}

object MyUtils {
    fun hello(name: String) {
        println("hello $name")
    }
}
package org.kotlinlang.play

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

fun log(vararg entries: String) {
    printAll(*entries)
}

fun main() {
    //lesson1 functions and printing msg
    println("hello from main with simple println")
    printMessage(message = "Hello from function")
    printMessageWithPrefix(
        "Hello message with custom prefix",
        "Log"
    )
    printMessageWithPrefix("Hello with autoprefix")
    printMessageWithPrefix(prefix = "Log", message = "Hello with variable prefix & message")
    println("call function sum and pass numbers 1 and 2 : " + sum(1, 2))

    //lesson2 functions, classes, variables
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "hello ")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia

    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )

    //lesson 3 variables
    var a: String = "hello string variable"
    println(a)
    val b: Int = 1
    val c = 3
    var e: Int = 15
    println(e)
}
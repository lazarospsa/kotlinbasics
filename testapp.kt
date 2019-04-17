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

fun someCondition(x: Int, y: Int){
    println(sum(x,y))
}


fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        println("$maybeString")
        return "String of length ${maybeString.length}"

    } else {
        println("empty")
        return "Empty or null string"
    }
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

class Customer

class Contact(val id: Int, var email: String)

class MutableStack<E>(vararg items: E) {              // 1

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // 2

    fun peek(): E = elements.last()                     // 3

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

open class Dog {                // 1
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("wif wif!")
    }
}

fun cases(obj: Any) {                                // 1
    when (obj) {
        1 -> println("One")                          // 2
        "Hello" -> println("Greeting")               // 3
        is Long -> println("Long")                   // 4
        !is String -> println("Not a string")        // 5
        else -> println("Unknown")                   // 6
    }
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4
        else -> 42                              // 5
    }
    return result
}

fun eatACake() = println("Eat a Cake")

fun bakeACake() = println("Bake a Cake")

class MyClass

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {             // 1
        return animals.iterator()                           // 2
    }
}


fun main(args: Array<String>) {
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

    val d: Int

    someCondition(4,5)

    val l: Int = 10
    val m: Int = 20

    if (l < m) {
        d = 1
        println("to l einai mikrotero tou m")
    } else {
        d = 2
        println("to l einai megalutero tou m")
    }

    println(d)

    var nullable: String? = "You can keep a null here with ? after string"

    nullable = null

    var neverNull: String = "This can't be null"


    describeString(maybeString = "")

    //lesson 4 classes

    val customer = Customer()                   // 3

    val contact = Contact(1, "test@test.com")  // 4

    println(contact.id)                         // 5
    contact.email = "test10@test.com"            // 6

    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)

    //lesson 5 inheritance

    val dog: Dog = Yorkshire()
    dog.sayHello()

    //lesson 6 when statement
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")

    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))

    //lesson 7 loops
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {                               // 1
        println("Yummy, it's a $cake cake!")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 5) {                    // 1
        eatACake()
        cakesEaten ++
    }

    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

    for (animal in zoo) {                                   // 3
        println("Watch out, it's a ${animal.name}")
    }

    //lesson 8 ranges

    for(i in 0..3) {             // 1
        print(i)
    }
    print(" ")

    for(i in 2..8 step 2) {      // 2
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {      // 3
        print(i)
    }
    print(" ")

    for (c in 'a'..'d') {        // 1
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) { // 2
        print(c)
    }
    print(" ")

    val x = 2
    if (x in 1..10) {            // 1
        print(x)
    }
    print(" ")

    if (x !in 1..4) {            // 2
        print(x)
    }

    //lesson 9 equality checks

    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println("")
    println(authors == writers)   // 1
    println(authors === writers)  // 2

    //lesson 10 conditional expression
    fun max(a: Int, b: Int) = if (a > b) a else b         // 1

    println(max(99, -42))
}
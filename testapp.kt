package org.kotlinlang.play

import java.util.Random


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

    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

data class User(val name: String, val id: Int)

enum class State {
    IDLE, RUNNING, FINISHED                           // 1
}

enum class Color(val rgb: Int) {                      // 1
    RED(0xFF0000),                                    // 2
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)  // 3
}

sealed class Mammal(val name: String)                                                   // 1

class Cat(val catName: String) : Mammal(catName)                                        // 2
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    when (mammal) {                                                                     // 3
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"    // 4
        is Cat -> return "Hello ${mammal.name}"                                         // 5
    }                                                                                   // 6
}

class LuckDispatcher {                    //1
    fun getNumber() {                     //2
        var objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total")                                               //4

}

object DoAuth {                                                 //1
    fun takeParams(username: String, password: String){         //2
        println("input Auth parameters = $username:$password")
    }
}

class BigBen {                                  //1
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sum1(x: Int, y: Int) = x + y

fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x                                          // 2

data class Item(val name: String, val price: Float)                                   // 1

data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Float = this.items.maxBy { it.price }?.price ?: 0F    // 2

fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String                                             // 3
    get() = items.map { it.name }.joinToString()

fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"  // 1

val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)        // 1
val sudoers: List<Int> = systemUsers                              // 2

fun addSudoer(newUser: Int) {                                     // 3
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {                                  // 4
    return sudoers
}

val openIssues: MutableSet<String> = mutableSetOf("uniqueDescr1", "uniqueDescr2", "uniqueDescr3") // 1

fun addIssue(uniqueDesc: String): Boolean {
    return openIssues.add(uniqueDesc)                                                             // 2
}

fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "registered correctly." else "marked as duplicate and rejected."          // 3
}

const val POINTS_X_PASS: Int = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)   // 1
val EZPassReport: Map<Int, Int> = EZPassAccounts                                        // 2

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {                                        // 3
        println("Updating $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS  // 4
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach{                                                               // 5
            k, v -> println("ID $k: credit $v")
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

    //lesson 11 data classes

    val user = User("Alex", 1)
    println(user)                                          // 2

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser: ${user == secondUser}")   // 3
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode())                               // 4
    println(thirdUser.hashCode())

    // copy() function
    println(user.copy())                                   // 5
    println(user.copy("Max"))                              // 6
    println(user.copy(id = 2))                             // 7

    println("name = ${user.component1()}")                 // 8
    println("id = ${user.component2()}")

    //lesson 12 enum classes
    val state = State.RUNNING                         // 2
    val message = when (state) {                      // 3
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)

    val red = Color.RED
    println(red)                                      // 4
    println(red.containsRed())                        // 5
    println(Color.BLUE.containsRed())                 // 6

    //lesson 13 sealed classes

    println(greetMammal(Cat("Snowy")))

    //lesson 14 object keyword
    val d1 = LuckDispatcher()             //3
    val d2 = LuckDispatcher()

    d1.getNumber()                        //4
    d2.getNumber()

    rentPrice(10, 2, 1)
    println("")
    DoAuth.takeParams("foo", "qwerty")

    BigBen.getBongs(12)

    val sumResult = calculate(4, 5, ::sum1)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult")

    val func = operation()                                          // 3
    println(func(2))

    //lesson 15 lambda functions

    // All examples create a function object that performs upper-casing.
// So it's a function from String to String

    val upperCase1: (String) -> String = { str: String -> str.toUpperCase() } // 1

    val upperCase2: (String) -> String = { str -> str.toUpperCase() }         // 2

    val upperCase3 = { str: String -> str.toUpperCase() }                     // 3

// val upperCase4 = { str -> str.toUpperCase() }                          // 4

    val upperCase5: (String) -> String = { it.toUpperCase() }                 // 5

    val upperCase6: (String) -> String = String::toUpperCase                  // 6

    println(upperCase2("hello"))
    println(upperCase1("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))


    //lesson 16 extension functions and properties
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")                     // 4
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")

    println(null.nullSafeToString())
    println("Kotlin".nullSafeToString())

    //lesson 17 collections lists
    addSudoer(4)                                                  // 5
    println("Tot sudoers: ${getSysSudoers().size}")               // 6
    getSysSudoers().forEach{                                      // 7
            i -> println("Some useful info on user $i")
    }
    // getSysSudoers().add(5) <- Error!                           // 8

    //lesson 18 set
    val aNewIssue: String = "uniqueDescr4"
    val anIssueAlreadyIn: String = "uniqueDescr2"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")                              // 4
    println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")

    //lesson 19 map
    accountsReport()                                                                    // 6
    updatePointsCredit(1)                                                               // 7
    updatePointsCredit(1)
    updatePointsCredit(5)                                                               // 8
    accountsReport()
}
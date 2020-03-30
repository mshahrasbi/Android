fun main() {
    println("Hello Mohammad")

    var age: Int = 32
    age = 30
//    age = "30"

    val me = "mohammad"
//    me = "mahroo"
    println("I am $age years old I love $me")

    var weight: Double = 188.6
    var radius = 6
    var pi = 3.14
    var c = radius * pi * 2
    println(c)
    var c1: Int = radius * pi.toInt() * 2
    println(c1)

    var wallet = 40
    wallet -= 5
    wallet += 20
    println(wallet)

    var isTheDogAlive: Boolean = true

    if (isTheDogAlive) {
        println("true")
    } else {
        println("false")
    }

    var luckyNumbers = listOf<Int>(1,2,3,4,5)   // immutable
    var luckyNumbers0: List<Int> = listOf(1,2,3,4,5)   // immutable
    var luckyNumbers1 = listOf(1,2,3,4,5)       // immutable
    var luckyNumbers2 = arrayOf(1,2,3,4,5)      // immutable
    var luckyNumbers3 = arrayOf<Int>(1,2,3,4,5) // immutable
    var luckyNumbers4 = mutableListOf(1,2,3,4,5)
    luckyNumbers4.add(4)


    for(x in 1..10) {
        print(x)
    }
    println()
    for(x in luckyNumbers) {
        print(x)
    }
    println()

    var dogs = mapOf("fido" to 8, "sarah" to 17, "sean" to 6)
    println(dogs["fido"])
    for (x in dogs) {
        println(x)
    }
    println()

    var mdogs = mutableMapOf("fido" to 8, "sarah" to 17, "sean" to 6)
    mdogs["mmmm"] = 12
    for (x in mdogs) {
        println(x)
    }

    fun sayHi() {
        println("Hello")
    }
    sayHi()

    fun doAdd(a: Int,b: Int = 10): Int {
        return  a + b
    }

    println(doAdd(2, 4))
    println(doAdd(2))

    fun doAdd1(a: Int,b: Int = 10) = a + b


    class Dog {
        var name = ""
        var age = 0
    }

    var myDog = Dog()

    class Dog0 {
        var name: String
        var age: Int

        init{
            this.name = ""
            this.age = 0
        }
    }

    class Dog1 {
        var name: String
        var age: Int

        constructor(name: String, age: Int){
            this.name = name
            this.age = age
        }

        constructor() {
            this.name = ""
            this.age = 0
        }

        fun dogInfo() {
            println("$name is $age years old")
        }
    }
    var myDog1 = Dog1("qqq", 1)
    myDog1.dogInfo()

    class Dog2(var name: String, var age: Int) {}
    var myDog2 = Dog2("", 1)

    // nullable
    var myAge: Int? = 28
    myAge = null
    if (myAge != null) {
        age = myAge!!
    }

    var ourDog: Dog? = Dog()
    ourDog = null
}
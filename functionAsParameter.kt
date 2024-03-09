package functionPractice

fun main() {
    //test1Parent(){ test1() }

    //test1Parent(::test1)

    //test2Parent { test2(it) } // Note: If the lambda is the only argument in that call, the parentheses can be omitted entirely

    //test3Parent(::test3) // Note: using function reference

    val sum = test4Parent(2, 3, ::sum)

    println("sum : $sum")


    val multiply = test4Parent(3, 4, ::multiply)

    println("multiply : $multiply")

    val subtraction = test4Parent(3, 4, subtraction) // Note: When function is stored in a value

    println("subtraction : $subtraction")
}

// Testing function as an argument with no arguments
fun test1() {
    println("test1 invoked!!")
}

fun test1Parent(funName: () -> Unit) {
    funName()
}

// Testing function as an argument with arguments
fun test2(name: String) {
    println("calling from $name!!")
}

fun test2Parent(funName: (String) -> Unit) {
    funName.invoke("test2Parent")
}

// Testing function as an argument with 2 arguments
fun test3(a: Int, b: Int): Int {
    println("test3 invoked!")
    return a + b
}

fun test3Parent(funName: (Int, Int) -> Int) {
    println("test3Parent invoked!")
    funName(1, 2)
}


// Testing function as an argument with 2 arguments
fun sum(a: Int, b: Int): Int {
    println("sum fun invoked!")
    return a + b
}

fun multiply(a: Int, b: Int): Int {
    println("multiply fun invoked!")
    return a * b
}

fun test4Parent(a: Int, b: Int, funName: (Int, Int) -> Int): Int {
    println("test4Parent invoked!")
    return funName(a, b)
}

val subtraction = { a: Int, b: Int -> a - b }

package org.atg0606.effectivekotlin.chapter1

fun main() {

        val factorial = Item5().factorial(5)
    println(factorial)
}

class Item5 {

    // 아규 먼트 (require)
    fun factorial(n: Int): Int {
        require(n >= 0)
        return if (n <= 1) 1 else factorial(n - 1) * n
    }

    // 상태 (check)
    fun speak(text: String) {
        check(true)
    }

    // nullability 와 스마트 캐스팅
}
package org.atg0606.effectivekotlin.item

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Item2Test {

    @Test
    fun run() {
        var numbers = (2..100).toList()
        val primes = mutableListOf<Int>()
        while (numbers.isNotEmpty()) {
            val prime = numbers.first()
            primes.add(prime)
            numbers = numbers.filter { it % prime != 0 }
        }

        println(primes)
    }

    @Test
    fun sequence() {

        val primes: Sequence<Int> = sequence {
            var numbers = generateSequence(2) { it + 1 }

            while (true) {
                val prime = numbers.first()
                yield(prime)
                numbers = numbers.drop(1).filter { it % prime != 0 }
            }
        }

        println(primes.take(10).toList())
    }

    @Test
    fun sequence2() {

        val primes: Sequence<Int> = sequence {
            var numbers = generateSequence(2) { it + 1 }

            var prime : Int
            while (true) {
                prime = numbers.first()
                yield(prime)
                numbers = numbers.drop(1).filter { it % prime != 0 }
            }
        }

        println(primes.take(10).toList())
    }
}
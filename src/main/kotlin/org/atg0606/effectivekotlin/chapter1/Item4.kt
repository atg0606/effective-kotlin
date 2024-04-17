package org.atg0606.effectivekotlin.chapter1


// inferred 타입으로 리턴하지 말라

class Item4 {
}

open class Animal
class Zebra : Animal()

fun main() {
    // Type mismatch: inferred type is Animal but Zebra was expected
//    var animal = Zebra()
//    animal = Animal()

    var animal: Animal = Zebra()
    animal = Animal()
}
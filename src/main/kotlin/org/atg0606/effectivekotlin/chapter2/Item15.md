
# 리시버를 명시적으로 참조하라

클래스의 메서드라는 것을 나타내기 위한 this 가 있습니다.

```kotlin
class User: Person() {

    private var beersDrunk: Int = 0
    
    fun drinkBeers(num : Int) {
        // ...
        this.beersDrunk += num
        // ...
    }
}

```

비슷하게 확장 리시버(확장 메서드에서의 this)를 명시적으로 참조하게 할 수도 있습니다.

```kotlin
fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size < 2) return this
    val pivot = first()
    val (smaller, bigger) = drop(1).partition { it <= pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}
```

명시적으로 표시한 경우

```kotlin

fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size < 2) return this
    val pivot = this.first()
    val (smaller, bigger) = this.drop(1)
        .partition { it <= pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}

// 두 함수 사용에 차이는 없습니다.

listOf(3, 2, 5, 1, 6).quickSort() // [1, 2, 3, 5, 6]
listOf("C", "D", "A", "B").quickSort() // [A, B, C, D]

```

일반적으로 also 또는 let 을 사용하는 것이 nullable 을 처리할 때 훨씬 좋은 선택지 입니다.





연산자 오버로딩은 굉장히 강력한 기능이지만, '큰 힘에는 큰 책임이 따른다' 는 말처럼 위험할 수 있습니다.

교육자로서 많은 학생이 연산자 오버로딩을 처음 공부할 때, 연산자 오버로딩의 매력에 빠져드는 것을 많이 보았습니다.

```kotlin

fun Int.factorial(): Int = (1..this).product()

fun Iterable<Int>.product() : Int = fold(1) { acc, i -> acc * i }

```

이 함수는 Int 확장 함수로 정의되어 있으므로, 굉장히 편리하게 사용할 수 있습니다.

```kotlin
print(10 * 6.factorial()) // 7200
```

```kotlin
// 중고등학교 수학 시간에 배운 팩토리얼
10 * 6!

// 코틀린은 이런 연산자를 지원하지 않지만, 다음과 같이 연산자 오버로딩을 활용하면,
// 만들어 낼 수 있습니다.

operator fun Int.not() = factorial()
print(10 * !6) // 7200 -> 당연히 안됨
print(10 * 6.not()) // 7200
```

!a = a.not()

! 연산자는 not 이므로 논리 연산에 사용되어야 함. 따라서 이런식으로 사용하는 것은 좋지 않습니다.

```kotlin
operator fun Int.times(operation: () -> Unit) {
    repeat(this) {
        operation()
    }
}

3 * { println("Hello") } // 출력 : HelloHelloHello
```

의미가 명확하지 않다면, infix를 활용한 확장 함수를 사용하는 것이 좋습니다.

```kotlin

// infix 확장 함수를 사용한 예시
infix fun Int.timesRepeated(operation: () -> Unit) {
    repeat(this) {
        operation()
    }
}

val tripledHello = 3 timesRepeated { println("Hello") }
tripledHello() // 출력 : HelloHelloHello

// 톱레벨 함수를 사용한 예시
repeated(3) { println("Hello") }

```

## 정리

연산자 오버로딩은 그 이름의 의미에 맞게 사용해 주세요.

연산자 의미가 명확하지 않다면, 연산자 오버로딩을 사용하지 않는 것이 좋습니다.

이름이 있는 일반 함수를 사용하고, 연산자 같은 형태로 사용하고 싶다면,
infix 확장 함수 또는 톱레벨 함수를 활용하세요



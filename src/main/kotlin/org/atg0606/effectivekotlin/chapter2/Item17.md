
# 이름 있는 아규먼트를 사용하라 

코드에서 아규먼트의 의미가 명확하지 않은 경우가 있습니다.

파라미터가 명확하지 않은 경우 직접 지정해서 명확하게 만들어 줄 것 

```kotlin

val text = (1..10).joinToString { "|" }
// joinToString 함수를 사용할 때 separator 라는 이름을 사용하여 명확하게 만들어 준 것
val text = (1..10).joinToString { separator = "|" }

// 변수를 사용하여 명확하게 한것 
val separator = "|"
val text = (1..10).joinToString(separator = separator)

```

이름있는 아규먼트는 파라미터의 순서를 잘못 지정해도 문제가 발생하지 않습니다.
또한, 코드를 읽는 사람들에게도 굉장히 중요한 정보입니다.

```kotlin

sleep(1000)

sleep(timeMillis = 1000)

```

같은 타입의 파라미터가 많은 경우 더 효과적입니다.

```kotlin

fun sendEmail(to: String, message: String) { /* ... */ }

sendEmail(
    to = "contact@gmail.com",
    message = "Hello"
)

```


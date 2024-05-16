
# Unit? 을 리턴하지 말라

일반적으로 Unit? 을 사용한다는 것은 이런 경우입니다. 

```kotlin
fun keyIsCorrect(key: String): Boolean = // ...

if (!keyIsCorrect(key)) return
```

```kotlin
fun verifyKey(key: String): Unit? = // ...

verifyKey(key) ?: return
```

Unit으로 boolean 을 표현하는 것은 오해의 소지가 있으며,
얘측하기 어려운 오류를 만들 수 있습니다.

```kotlin
// 다음 두 가지 코드를 비교해봅시다.

if (!keyIsCorrect(key)) return

verifyKey(key) ?: return

```

Unit?을 쉽게 읽을 수 있는 경우는 거의 없습니다.

## 생각 정리 

저 역시 Unit?을 사용하는 것은 좋지 않다고 생각합니다.
자바에 익숙해서 그런지 책과 동일하게 Unit? 보다는 Boolean 이 더 
가독성 있게 느껴졌습니다.
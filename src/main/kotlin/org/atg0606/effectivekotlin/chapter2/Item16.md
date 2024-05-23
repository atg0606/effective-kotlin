
# 프로퍼티는 동작이 아니라 상태를 나타내야 한다.

코틀린의 프로퍼티는 자바의 필드와 비슷해 보입니다.

```kotlin

// 코틀린의 프로퍼티
var name: String? = null

// 자바의 필드
String name = null;

```

둘다 데이터를 저장한다는 점은 같지만, 프로퍼티에 더 많은 기능이 있습니다.

프로퍼티는 사용자 정의 세터와 게터를 가질 수 있습니다.

```kotlin

var name: String? = null
    get() = field?.toUpperCase()
    set(value) {
        if (value != null) {
            field = value
        }
    }

```

이 코드에서 field 라는 식별자는 백킹 필드에 대한 레퍼런스입니다.

백킹 필드는 세터와 게터의 디폴트 구현에 사용되므로, 따로 만들지 않아도 디폴트로 생성됩니다.

참고로 val 을 사용해서 읽기 전용 프로퍼티를 만들 때는 field 가 만들어지지 않습니다.

```kotlin
val fullName: String
    get() = "$name $lastName"

```

프로퍼티는 필드가 필요 없습니다.

오히려 프로퍼티는 개념적으로 접근자(val)의 경우 게터, var 의 경우 게터와 세터를 나타냅니다.

따라서 코틀린은 인터페이스에도 프로퍼티를 정의할 수 있는 것 

```kotlin
interface Person {
    val name: String
}
// 게터만 가질 거라는 것을 나타냅니다.
// 따라서 다음과 같이 오버라이드 할 수 있습니다.
open class Supercomputer {
    open val theAnswer: Long = 42
}

class AppleComputer : Supercomputer() {
    override val theAnswer: Long = 1_800_275_2273
}

// 프로퍼티를 위임할 수도 있습니다.
val db: Database by lazy { connectToDb() }


```

프로퍼티로 알고리즘의 동작을 나타내는 것은 좋지 않습니다. 

- 연산 비용이 높거나, 복잡도가 O(1) 이상인 경우 -> 함수로 만들어야 합니다.
- 비즈니스 로직을 포함하는 경우 -> 관습적으로 프로퍼티가 단순한 동작 이상을 할 것이라고 기대하지 않습니다.
- 결정적이지 않은 경우 -> 함수로 만들어야 합니다.
- 변환의 경우 -> 함수로 만들어야 합니다.
- 게터에서 프로퍼티의 상태 변경이 일어나야하는 경우 -> 관습적으로 게터에서 프로퍼티의 상태 변화를 기대하지 않습니다.

### 내 생각

프로퍼티는 상태를 나타내는 것이 좋다는 것은 동의합니다.
자바의 변수와 동일하다고 생각하고 사용해왔음.
다만, 프로퍼티는 변수와 다르게 세터와 게터를 가질 수 있지만 기존 처럼 사용할 것 같음.
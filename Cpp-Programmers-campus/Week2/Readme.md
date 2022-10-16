# Chapter 4

가장 관심을 가져야 할 부분은 `function`이다. function을 잘 만들 줄 알아야 한다.

코딩 전략 : divide and conquer == use function especially

## Computation
Programming 목적 : computation, input에 대해서 우리가 어떤 방법을 써서 원하는 방향(output)으로 변화시키는 것

개발자(우리)가 하는 일은 computation을 완성시키는 것이다.
개발자 덕목
- Correctly : 원하는 output이 correct
- Efficiently : resource를 적게 쓴다
- Simply : simple is beauty

Resource는 시간과 공간. 상대적으로 시간이 더 중요하다(교수님피셜)

## 가장 중요한 방법론(전략)
**Divide and Conquer** 
: 한번에 해결하는 것이 아니라 sub problem으로 쪼개어 각각을 해결하기 -> function 사용</br>
**Abstraction**
: 필요한 것만 보여주고 나머지는 추상화. OPP에서 지향 -> Class


## Function ⭐
declaration : 이름, 형식, 갯수, 타입... 이는 모두 compiler를 위해 필요하다.

define
```C++
#include <iostream>
using namespace std;

void myfunc(){
cout << "my" << endl;
}

void myfunc(int a){
cout << a << endl;
}

int main(){
	myfunc();
}
```
C++는 **다형성** 의 연장성으로 매개변수로 구별할 수있으면 함수의 이름이 같아도 중복으로 생각하지 않는다.

### Function 장점
- 코드의 재사용 가능
- Control Flow 가 명확하다.  ↔ Go to와 대비
- Divide and Conquer가 하는 중요한 기능

## Data for Iteration - Vector
Array : 주소의 연속성이 보장, 따라서 random access가 보장된다. 단점은 memory allo기보

🆚

Linked list :  하나씩 memory allocation 받는 것. 대신 연결을 해주고 기억해야함. 메모리 flexability가 좋음, 공간 효율성 좋다 단점 : random access가 안됨

random access도 가능한데 공간에 대한 효율성도 높은 게 없을까?

### Vector

random access 🙆 memory 효율성🙆

기본적으로 **Array** 이고 doubling을 사용함

자리가 부족하면 메모리 두배로 복사해 바꿔치기

데이터가줄어들면 반을 나눠서 반납

array바꿔치기 할때 overhead?는 무시할 수 있는 수준이다.

space에 대한 동적관리도 가능

- vector는 길이 제한 없이 계속 push back 할 수있다.

예제
```C++
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
	vector<string> words;
	for (string s; cin>>s && s != "quit";)
		words.push_back(s);

	sort(words.begin(),words.end());

	for (int i= 1; i < words.size(); i++)
		cout <<words[i] << '\n';
}
```
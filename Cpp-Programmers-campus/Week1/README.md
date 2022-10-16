

### 이전 시간
readability 높이는 것이 중요 : indentation, function name, function devide and conquer, 문법 적절히 사용(ex. const)

### C Language와 다른 점
scanf x cin >>
printf x cout <<

### Practice 1
Write a program that prompts the user to enter two interger calues. Store the calues in int variables named val1 and val2. Write your program to determine the smmalest, largest, sum, difference, product, and ratio of these values and report

```#include  <iostream>

using  namespace  std;

  

extern  int  j; //reserved keyword 를 쓰면 declaration 만 하는 것

  

int  main(){

int  val1, val2;

int  largest, smallest;

  

cout  <<  "Please enter two integers: ";

cin  >>  val1  >>  val2

if (val1 > val2){

largest = val1;

smallest = val2;

}else{

largest = val2;

smallest = val1;

}

  

cout <<"largest : " << largest << endl; //endl은 \n

cout  <<"smallest : "  <<  smallest  <<  endl; //endl은 \n

cout  <<"sum : "  << (largest+smallest) <<  endl; //endl은 \n

cout  <<"difference : "  << (largest - smallest) <<  endl;

cout  <<"mul : "  <<  largest*smallest  <<  endl; //endl은 \n

cout  <<"ratio : "  <<  largest/smallest  <<  endl; //endl은 \n

return  0;

}```

### Practice2

3 integer 받아서 순서대로 작은 순서대로

Write a program that prompts the user to enter 3 integer values, and then outputs the values in numerical sequence separated by commas. So: if the user enters the values to 4 6, the output shoud be
```
#include <iostream>
using namespace std;

int main(){
	int val1, val2, val3;
	int one, two, three;
	int i;
	cout << "Please enter three integers: ";
	cin >> val1 >> val2 >> val3;
	
	one = val1;
	i = 1;
	if(one > val2){
		one = val2;
		i = 2;
	}
	if(one > val3){
		one = val3;
		i = 3;
	}

	if(i ==1){
		if (val2 > val3){
			two = val3;
			three = val2;
		}else{
			two = val2;
			three= val3;
		}
	}else if (i == 2)
	{
		if(val1>val3){
			two = val3;
			three = val1;
		}else{
			two = val1;
			three= val3;
		}

	}else if (i == 3)
	{
		if(val1>val2){
			two = val2;
			three = val1;
		}else{
			two = val1;
			three= val2;
		}
	}

	cout << one <<", " << two<< ", " << three ;
	return 0;
}
```
### Practice3

숫자 하나를 받아서 홀짝

the value 4 is an even number

the value 3 is an odd number

### Practice 4

Write a program that converts spelled out numbers such as “zero” and “two” into digits, such as 0 and 2. When the user inputs a number, print out the corresponding digit. Do it for the values 0,1,2,3,4 and 4 and write out “not a number I know” if the user enter something that doesn’t correspond, such as “stupid computer!”

</hr>
## C++은..
주소가 같은지 비교하는 게 아니라 value가 같은지 비교하는 것이다!
java같은 경우에는 주소를 비교한다.

`switch는 user definde에 해당하는 string을 사용할 수 없다.`

### Practice5

Write a program that takes an operattion followed by two operands and outputs the result. For ex

+100 3.14

숫자는 기본적으로 double type
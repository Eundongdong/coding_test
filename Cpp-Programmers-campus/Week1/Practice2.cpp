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
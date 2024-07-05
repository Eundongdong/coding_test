#include <iostream>
using namespace std;

extern int j; //reserved keyword 를 쓰면 declaration 만 하는 것

int main(){
	int val1, val2;
	int largest, smallest;

	cout << "Please enter two integers: ";
	cin >> val1 >> val2;
	
	if(val1 > val2){
		largest = val1;
		smallest = val2;
	}else{
		largest = val2;
		smallest = val1;
	}

	cout <<"largest : " << largest << endl; //endl은 \n
	cout <<"smallest : " << smallest << endl; //endl은 \n
	cout <<"sum : " << (largest+smallest) << endl; //endl은 \n
	cout <<"difference : " << (largest - smallest) << endl;
	cout <<"mul : " << largest*smallest << endl; //endl은 \n
	cout <<"ratio : " << largest/smallest << endl; //endl은 \n
	
	return 0;
}
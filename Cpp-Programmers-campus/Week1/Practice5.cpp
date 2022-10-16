#include <iostream>
#include <string>
using namespace std;

int main(){
	char operand;
	double num1, num2, res;
	cin >> operand >> num1 >> num2;
	
	switch(operand){
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num1 / num2;
			break;
		default:
			cout << "Not a case I Know" << endl;
	}
	cout <<"result is " << res;
	return 0;

}
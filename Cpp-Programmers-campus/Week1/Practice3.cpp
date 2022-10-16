#include <iostream>
#include <string>
using namespace std;

int main(){
	int num;
	string cat;
	
	cin >> num;
	
	if (num %2 == 0){
		cat = "even";
	}else{
		cat = "odd";
	}

	cout << "the value " << cat << " is an " << cat << " number." << endl;

	return 0;

}
#include <iostream>
#include <string>
using namespace std;

int main(){
	string strnum;

	cin >> strnum;	
	if(strnum =="zero"){
		cout <<0;
	}else if(strnum =="one"){
		cout <<1;
	}else if(strnum =="two"){
		cout <<2;
	}else if(strnum =="three"){
		cout <<3;
	}else if(strnum =="four"){
		cout <<4;
    }else{
		cout <<"not a value I know";
	}
	return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main(){
	vector<pair<int,string> >v; //한 쌍의 데이터를 다루기 위해 사용할 수 있는 라이브러리 첫번째를 기준으로 정렬됨 
	v.push_back(pair<int,string>(90,"박한을"));
	v.push_back(pair<int,string>(15,"장미"));
	v.push_back(pair<int,string>(35,"위시윙"));
	v.push_back(pair<int,string>(60,"용용이"));
	v.push_back(pair<int,string>(99,"김은지"));
	
	sort(v.begin(),v.end());
	for(int i=0;i<v.size();i++){
		cout<<v[i].second<<endl; //second 는 이름 정보 출력  
	}
}

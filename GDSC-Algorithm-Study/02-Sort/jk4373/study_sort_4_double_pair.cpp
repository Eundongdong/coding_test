#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool compare(pair<string, pair<int,int> > a,pair<string, pair<int,int> > b){
	if(a.second.first == b.second.first){
		return a.second.second > b.second.second;
	}else{
		return a.second.first > b.second.first;
	}
}

int main(){
	vector<pair<string, pair<int,int> > >v; //한 쌍의 데이터를 다루기 위해 사용할 수 있는 라이브러리 첫번째를 기준으로 정렬됨 
	v.push_back(pair<string, pair<int,int> >("나동빈",pair<int,int>(90,19961222)));
	v.push_back(pair<string, pair<int,int> >("용용",pair<int,int>(50,20000101)));
	v.push_back(pair<string, pair<int,int> >("장미",pair<int,int>(30,20100510)));
	v.push_back(pair<string, pair<int,int> >("위시윙",pair<int,int>(40,20070411)));
	v.push_back(pair<string, pair<int,int> >("김은지",pair<int,int>(90,20000604)));
	
	sort(v.begin(),v.end(),compare);
	for(int i=0;i<v.size();i++){
		cout<<v[i].first<<endl; //second 는 이름 정보 출력  
	}
}

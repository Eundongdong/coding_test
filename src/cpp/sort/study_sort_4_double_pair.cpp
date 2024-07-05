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
	vector<pair<string, pair<int,int> > >v; //�� ���� �����͸� �ٷ�� ���� ����� �� �ִ� ���̺귯�� ù��°�� �������� ���ĵ� 
	v.push_back(pair<string, pair<int,int> >("������",pair<int,int>(90,19961222)));
	v.push_back(pair<string, pair<int,int> >("���",pair<int,int>(50,20000101)));
	v.push_back(pair<string, pair<int,int> >("���",pair<int,int>(30,20100510)));
	v.push_back(pair<string, pair<int,int> >("������",pair<int,int>(40,20070411)));
	v.push_back(pair<string, pair<int,int> >("������",pair<int,int>(90,20000604)));
	
	sort(v.begin(),v.end(),compare);
	for(int i=0;i<v.size();i++){
		cout<<v[i].first<<endl; //second �� �̸� ���� ���  
	}
}

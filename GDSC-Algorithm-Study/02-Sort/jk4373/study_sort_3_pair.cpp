#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main(){
	vector<pair<int,string> >v; //�� ���� �����͸� �ٷ�� ���� ����� �� �ִ� ���̺귯�� ù��°�� �������� ���ĵ� 
	v.push_back(pair<int,string>(90,"������"));
	v.push_back(pair<int,string>(15,"���"));
	v.push_back(pair<int,string>(35,"������"));
	v.push_back(pair<int,string>(60,"�����"));
	v.push_back(pair<int,string>(99,"������"));
	
	sort(v.begin(),v.end());
	for(int i=0;i<v.size();i++){
		cout<<v[i].second<<endl; //second �� �̸� ���� ���  
	}
}

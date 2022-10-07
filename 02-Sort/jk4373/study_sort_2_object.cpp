#include <iostream>
#include <algorithm>

using namespace std;

class Student {
public:
	string name;
	int score;
	//생성자 - 초기화 하기위해서  
	Student(string name, int score) {
		this->name = name;
		this->score = score;
	}
	//정렬 기준은 ' 점수가 작은 순서' 
	bool operator<(Student &student){
		return this->score>student.score; //다른 학생과 비교할때 내가 작은게 트 류
		 
	} 
}; 

int main(void){
	Student students[] ={
		Student("나동빈",90),
		Student("김가나",65),
		Student("임용사",50),
		Student("방방방",50),
		Student("쌍쌍방",40)
	};
	sort(students,students+5);
	for (int i=0;i<5;i++){
		cout<<students[i].name<<endl;
	}
}




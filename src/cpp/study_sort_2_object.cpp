#include <iostream>
#include <algorithm>

using namespace std;

class Student {
public:
	string name;
	int score;
	//������ - �ʱ�ȭ �ϱ����ؼ�  
	Student(string name, int score) {
		this->name = name;
		this->score = score;
	}
	//���� ������ ' ������ ���� ����' 
	bool operator<(Student &student){
		return this->score>student.score; //�ٸ� �л��� ���Ҷ� ���� ������ Ʈ ��
		 
	} 
}; 

int main(void){
	Student students[] ={
		Student("������",90),
		Student("�谡��",65),
		Student("�ӿ��",50),
		Student("����",50),
		Student("�ֹֽ�",40)
	};
	sort(students,students+5);
	for (int i=0;i<5;i++){
		cout<<students[i].name<<endl;
	}
}




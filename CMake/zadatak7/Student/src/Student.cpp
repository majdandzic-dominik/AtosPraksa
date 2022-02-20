#include "Student/Student.h"

string Student::getName(){
    return studentName;
}
Student::Student(){}
Student::~Student(){}
Student::Student(string name){
    studentName = name;
}
ostream& operator<<(ostream& os, Student& student){
    os << "Student's name: " << student.getName() << "\n";
    return os;
}


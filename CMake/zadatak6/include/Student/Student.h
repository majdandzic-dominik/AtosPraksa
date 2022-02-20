#include <iostream>
#include <cstring>
using namespace std;

class Student {
    private:
        string studentName;
    public:
        string getName();
        Student();
        ~Student();
        Student(string name);
        friend ostream& operator<<(ostream& os, Student& student);
};

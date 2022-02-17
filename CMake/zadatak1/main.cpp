#include <iostream>
#include <cstring>
#include <Professor.h>
#include <Student.h>

using namespace std;





int main(){
    string name;
    cout << "Enter student's name: ";
    cin >> name;
    Student student(name);
    cout << "Enter professor's name: ";
    cin >> name;
    Professor professor(name);
    cout << "\n";
    cout << student;
    cout << professor;
    return 0;
}

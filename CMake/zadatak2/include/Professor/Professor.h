#include <iostream>
#include <cstring>
using namespace std;

class Professor {
    private:
        string professorName;
    public:
        string getName();
        Professor();
        ~Professor();
        Professor(string name){;
        friend ostream& operator<<(ostream& os, Professor& professor);
};

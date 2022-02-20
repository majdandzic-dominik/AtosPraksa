#include "Professor/Professor.h"

string Professor::getName(){
    return professorName;
}
Professor::Professor(){}
Professor::~Professor(){}
Professor::Professor(string name){
    professorName = name;
}
ostream& operator<<(ostream& os, Professor& professor){
    os << "Professor's name: " << professor.getName() << "\n";
    return os;
}


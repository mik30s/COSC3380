#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>

int main() {
    std::cout << "Running prog2\n";
    std::ifstream in("C:\\Users\\mike168m\\Documents\\COSC3380\\lab2\\temp.txt");
    std::string line, name;
    int age;
    std::vector<std::string> lines;
    while(std::getline(in, line)) {
        in >> name >> age;
        if (age < 0 || age > 120) {
            return -1;        
        } 
    }
    return 0;
}
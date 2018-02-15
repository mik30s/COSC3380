#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>

int main() {
    std::ifstream in("C:\\Users\\mike168m\\Documents\\COSC3380\\lab2\\temp.txt");
    std::string line, name;
    int age;
    std::vector<std::string> lines;
    
    while(std::getline(in, line)) {
        lines.push_back(line);
    }

    std::remove_if(lines.begin(), lines.end(), 
        [](std::string s) {
            return std::stoi(std::string(s, s.size() - 3, 2)) < 20;
        });
    for(auto s : lines)  {
	    std::cout << s << '\n';
    }
}
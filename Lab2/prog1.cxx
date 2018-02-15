#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>


int main(int argc, char** argv) {
    std::cout << "Running prog1\n";
    std::ifstream in(argv[1]);
	std::cout << "executing "<< argv[1] << '\n';
    std::ofstream on("C:\\Users\\mike168m\\Documents\\COSC3380\\lab2\\temp.txt");
    char c;
    std::string line;
    std::vector<std::string> lines;
    
    while(std::getline(in, line)){
        lines.push_back(line);
    }
    std::sort(lines.begin(), lines.end());
    for (auto l: lines) {
        on << l << '\n';
    }
}
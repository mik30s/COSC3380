#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

int main() {
    std::cout << "Running prog1\n";
    std::ifstream in("file1.txt");
    std::ofstream on("temp.txt");
    char c;
    std::string line;
    std::vector<std::string> lines;
    
    while(std::getline(in, line)){
        lines.push_back(line);
    }
    std::sort(lines.begin(), lines.end());
    for (auto l: lines) {
        on << l + '\n';
    }
}
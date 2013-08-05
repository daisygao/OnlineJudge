#include<iostream>
#include<cmath>
using namespace std;
int main() {
    double a, b;
    cin >> a >> b;
   	cout << (abs(a - b) < 1e-8 ? "yes" : "no");
    return 0;
}
    

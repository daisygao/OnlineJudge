#include <iostream>
#include <climits>
using namespace std;

int main() {
    int n, min = INT_MAX, max = INT_MIN, x;
    cin >> n;
    while (n-- > 0) {
        cin >> x;
        min = std::min(min, x);
        max = std::max(max, x);
    }
    cout << min << " " << max;
    return 0;
}
    

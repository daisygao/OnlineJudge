#include <iostream>
using namespace std;
int main() {
    int sum = 0, n, x;
    cin >> n;
    while (n-- > 0) {
        cin >> x;
        sum += x;
    }
    cout << sum;
    return 0;
}

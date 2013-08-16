/*
Hanoi
n start middle end
n - 1 from start to middle through end
nth from start to end
n - 1 from middle to end through start
*/
#include <cstdio>
#include <string>
#include <vector>
using namespace std;
int step;
vector<string> ans;
void hanoi(int n, char A, char B, char C) {
    if (n == 0) return;
    hanoi(n - 1, A, C, B);
    char buffer[100];
    sprintf(buffer, "%d from %c to %c\n", n, A, C);
    ans.push_back(string(buffer));
    step++;
    hanoi(n - 1, B, A, C);
}
int main() {
    int n;
    scanf("%d", &n);
    hanoi(n, 'A', 'B', 'C');
    printf("%d\n", step);
    for (vector<string>::iterator it = ans.begin(); it != ans.end(); it++) {
    	printf("%s", (*it).c_str());
    }
    return 0;
}


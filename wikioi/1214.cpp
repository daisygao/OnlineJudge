/*
给定x轴上的N（0<N<100）条线段，每个线段由它的二个端点a_I和b_I确定，I=1,2,……N.这些坐标都是区间（－999，999）的整数。有些线段之间会相互交叠或覆盖。请你编写一个程序，从给出的线段中去掉尽量少的线段，使得剩下的线段两两之间没有内部公共点。所谓的内部公共点是指一个点同时属于两条线段且至少在其中一条线段的内部（即除去端点的部分）。
输入第一行是一个整数N。接下来有N行，每行有二个空格隔开的整数，表示一条线段的二个端点的坐标。
输出第一行是一个整数表示最多剩下的线段数。

solution: greedy
pick the earliest end

1s 2s 3e 3s 5e 6e
find first end with start bigger or equal to INT_MIN, second end with start bigger or equal to first end
*/
#include <cstdio>
#include <algorithm>
#include <climits>
using namespace std;
struct Time {
    int start;
    int end;
    int operator<(const Time &o) const {
        return end == o.end ? start < o.start : end < o.end;
    }
};
int main() {
    int n;
    scanf("%d", &n);
    Time arr[n];
    for (int i = 0; i < n; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        arr[i] = {min(x, y), max(x, y)};
    }
    sort(arr, arr + n);
    int ans = 0, t = INT_MIN;
    for (int i = 0; i < n; i++) {
        if (arr[i].start >= t) {
            ans++;
            t = arr[i].end;
        }
    }
    printf("%d", ans);
    return 0;
}
    
/*
题目描述 Description
数轴上有n条线段，线段的两端都是整数坐标，坐标范围在0~1000000，每条线段有一个价值，请从n条线段中挑出若干条线段，使得这些线段两两不覆盖（端点可以重合）且线段价值之和最大。
n<=1000
输入描述 Input Description
第一行一个整数n，表示有多少条线段。
接下来n行每行三个整数, ai bi ci，分别代表第i条线段的左端点ai，右端点bi（保证左端点<右端点）和价值ci。
输出描述 Output Description
输出能够获得的最大价值
Solution:
sort according to end
sols[n] maximum value to index n
sols[n] = max(sols[i] + value, sols[n - 1]);
Test:
9
1 2 1
2 3 2
1 3 4
2 4 2 
4 5 8
3 6 9
3 5 12
6 9 11
2 8 32

1 2 1 1 
1 3 4 4
2 3 2 3.4
2 4 2 3.4
3 5 12 16
4 5 8 12.16
3 6 9 13.16
2 8 32 33
6 9 11 27.33
*/
#include <cstdio>
#include <algorithm>
#include <cstring>

struct Interval {
    int start, end, value;
    int operator<(const Interval &o) const {
        return end == o.end ? start < o.start : end < o.end;
    }
};
int main() {
    int n;
    scanf("%d", &n);
    Interval intervals[n];
    for (int i = 0; i < n; i++) {
        scanf("%d %d %d", &intervals[i].start, &intervals[i].end, &intervals[i].value);
    }
    std::sort(intervals, intervals + n);
    int sols[n];
    memset(sols, 0, sizeof(sols) / sizeof(char));
    for (int i = 0; i < n; i++) {
        int prev = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (intervals[j].end <= intervals[i].start) {
                prev = sols[j];
                break;
            }
        }
        sols[i] = std::max(prev + intervals[i].value, i == 0 ? 0 : sols[i - 1]);
    }
    printf("%d", sols[n - 1]);		
    return 0;
}
			
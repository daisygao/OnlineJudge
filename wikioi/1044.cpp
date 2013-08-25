/*
题目描述 Description
    某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。
  
输入描述 Input Description
输入导弹依次飞来的高度（雷达给出的高度数据是不大于30000的正整数）
  
输出描述 Output Description
输出这套系统最多能拦截多少导弹，如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。

*/
#include <cstdio>
#include <vector>

int main() {
    int x;  
    std::vector<int> asc, desc;
    while (scanf("%d", &x) == 1) {
        if (asc.size () == 0 || asc.back() <= x) {
            asc.push_back(x);
        } else {
            for (int i = 0; i < asc.size(); i++) {
                if (asc[i] > x) {
                    asc[i] = x;
                    break;
                }
            }
        }
        if (desc.size() == 0 || desc.back() >= x) {
            desc.push_back(x);
        } else {
            for (int i = 0; i < desc.size(); i++) {
                if (desc[i] < x) {
                    desc[i] = x;
                    break;
                }
            }
        }
    }
    printf("%d\n%d", desc.size(), asc.size());
    return 0;
}
 
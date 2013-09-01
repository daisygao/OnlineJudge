/*
题目描述 Description
已知有两个字串 A$, B$ 及一组字串变换的规则（至多6个规则）:
　　　　　A1$ -> B1$
　　　　　A2$ -> B2$
　　规则的含义为：在 A＄中的子串 A1$ 可以变换为 B1$、A2$ 可以变换为 B2$ …。
　　　　例如：A$＝'abcd'　B$＝'xyz'
　　变换规则为：
　　　　‘abc’->‘xu’　‘ud’->‘y’　‘y’->‘yz’

　　则此时，A$ 可以经过一系列的变换变为 B$，其变换的过程为：
　　　‘abcd’->‘xud’->‘xy’->‘xyz’

　　共进行了三次变换，使得 A$ 变换为B$。
输入描述 Input Description
输入格式如下：
　　　A$ B$
　　　A1$ B1$ \
　　　A2$ B2$  |-> 变换规则
　　　... ... / 
　　所有字符串长度的上限为 20。
输出描述 Output Description
若在 10 步（包含 10步）以内能将 A$ 变换为 B$ ，则输出最少的变换步数；否则输出"NO ANSWER!"
Solutions:
BFS
*/
#include <iostream>
#include <vector>
#include <string>
#include <set>
using namespace std;
int main() {
    string start, end, key, val;
    cin >> start >> end;
    vector<string> queue, keys, vals;
    set<string> dict;
    while (cin >> key >> val) {
        keys.push_back(key);
        vals.push_back(val);
    }
    vector<int> step;
    queue.push_back(start);
    step.push_back(0);
    dict.insert(start);
    int i = 0; 
    while (i < queue.size()) {
        string u = queue[i];
        int s = step[i];
        if (s >= 10) {
            break;
        }
        for (int j = 0; j < keys.size(); j++) {
            int len = keys[j].size(), pos = u.find(keys[j]);
            while (pos >= 0) {
                string v = u;
                v.replace(pos, len, vals[j]);
                if (v == end) {
                    cout << s + 1;
                    return 0;
                }
                if (dict.find(v) == dict.end()) {
                    queue.push_back(v);
                    step.push_back(s + 1);
                    dict.insert(v);
                }
                pos = u.find(keys[j], pos + len);
            }
        }
        i++;
    }
    cout << "NO ANSWER!";
    return 0;
}
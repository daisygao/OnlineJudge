class Solution {
public:
    unordered_map<string, vector<int>> map;
    vector<int> diffWaysToCompute(string input) {
        if (map.find(input) != map.end()) {
            return map[input];
        }
        vector<int> ans;
        for (int i = 0; i < input.size(); i++) {
            if (input[i] < '0' || input[i] > '9') {
                vector<int> ans1 = diffWaysToCompute(input.substr(0, i)), ans2 = diffWaysToCompute(input.substr(i + 1));
                for (auto x1 : ans1) {
                    for (auto x2 : ans2) {
                        if (input[i] == '+') ans.push_back(x1 + x2);
                        else if (input[i] == '-') ans.push_back(x1 - x2);
                        else if (input[i] == '*') ans.push_back(x1 * x2);
                    }
                }
            }
        }
        if (input.size() > 0 && ans.size() == 0) ans.push_back(stoi(input));
        map[input] = ans;
        
        return ans;
    }
};

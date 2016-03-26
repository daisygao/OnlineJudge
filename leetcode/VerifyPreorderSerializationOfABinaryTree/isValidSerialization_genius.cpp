class Solution {
public:
    vector<string> split(string str, char sep = ',') {
        stringstream ss(str);
        string s;
        vector<string> ans;
        while (getline(ss, s, sep)) {
            ans.push_back(s);
        }
        return ans;
    }
    
    bool isValidSerialization(string preorder) {
        int slots = 1;
        for (auto s : split(preorder)) {
            if (!slots) return false;
            if (s == "#") slots--;
            else slots++;
        }
        return !slots;
    }
};

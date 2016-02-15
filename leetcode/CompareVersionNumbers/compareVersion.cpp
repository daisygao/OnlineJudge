class Solution {
public:
    vector<string> strsplit(string str, char sep = '.') {
        vector<string> ans;
        stringstream ss(str);
        string s;
        while (getline(ss, s, sep)) {
            ans.push_back(s);
        }
        return ans;
    }
    int getVersion(string str) {
        int ans = 0;
        for (char c : str) {
            if (c < '0' || c > '9') return -1;
            ans = ans * 10 + (c - '0');
        }
        return ans;
    }
    int compareVersion(string version1, string version2) {
        vector<string> vs1 = strsplit(version1), vs2 = strsplit(version2);
        for (int i = 0; i < max(vs1.size(), vs2.size()); i++) {
            int n1 = i < vs1.size() ? getVersion(vs1[i]) : 0;
            int n2 = i < vs2.size() ? getVersion(vs2[i]) : 0;
            if (n1 == -1 || n2 == -1) return 0;
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }
        return 0;
    }
};

class Solution {
public:
    string getHint(string secret, string guess) {
        unordered_map<char, int> cntB;
        int A = 0, B = 0;
        for (int i = 0; i < secret.size(); i++) {
            if (secret[i] == guess[i]) A++;
            else {
                cntB[secret[i]]++;
            }
        }
        for (int i = 0; i < secret.size(); i++) {
            if (secret[i] == guess[i]) continue;
            if (cntB[guess[i]]-- > 0) B++;
        }
        ostringstream os;
        os << A << "A" << B << "B";
        return os.str();
    }
};

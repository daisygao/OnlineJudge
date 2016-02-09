class Solution {
public:
    string getHint(string secret, string guess) {
        unordered_map<char, int> cnt;
        int A = 0, B = 0;
        for (int i = 0; i < secret.size(); i++) {
            if (secret[i] == guess[i]) A++;
            else {
                if (cnt[secret[i]]++ < 0) B++;
                if (cnt[guess[i]]-- > 0) B++;
            }
        }
        return to_string(A) + "A" + to_string(B) + "B";
    }
};

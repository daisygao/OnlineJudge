class Solution {
public:
    int lengthOfLastWord(string s) {
        int size = s.size();
        if (!size) return 0;
        int begin = size - 1;
        while (begin >= 0 && s[begin] == ' ') begin--;
        int end = begin;
        while (end >= 0 && s[end] != ' ') end--;
        return begin - end;
    }
};

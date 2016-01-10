class Solution {
public:
  bool isHappy(int n) {
    unordered_set<int> map;
    return helper(n, &map);
  }
  bool helper(int n, unordered_set<int> *map) {
    if (map->find(n) != map->end()) return false;
    map->insert(n);
    if (n == 1) return true;
    int ans = 0;
    while (n) {
      int digit = n % 10;
      ans += digit * digit;
      n /= 10;
    }
    return helper(ans, map);
  }
};

public class Solution {
  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<Integer>();
    return helper(n, set);
  }
  private boolean helper(int n, HashSet<Integer> set) {
    if (set.contains(n)) return false;
    set.add(n);
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      sum += digit * digit;
      n /= 10;
    }
    if (sum == 1) return true;
    return helper(sum, set);
  }
}

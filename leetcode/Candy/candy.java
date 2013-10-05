public class Solution {
    private class Item {
        int rating;
        int idx;
        Item(int rating, int idx) {
            this.rating = rating;
            this.idx = idx;
        }
    }
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = ratings.length;
        if (len == 0) return 0;
        ArrayList<Item> queue = new ArrayList<Item>(len);
        int candies[] = new int[len], ans = 0, qi = 0;
        for (int i = 0; i < len; i++) {
            queue.add(new Item(ratings[i], i));
        }
        Collections.sort(queue, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return i1.rating - i2.rating;
            }
        });
        while (qi < queue.size()) {
            Item it = queue.get(qi++);
            int lidx = it.idx - 1, ridx = it.idx + 1;
            candies[it.idx] = 1 + Math.max(lidx >= 0 && ratings[lidx] < ratings[it.idx] ? candies[lidx] : 0, 
            ridx < len && ratings[ridx] < ratings[it.idx] ? candies[ridx] : 0);
            ans += candies[it.idx];
        }
        return ans;
    }
}
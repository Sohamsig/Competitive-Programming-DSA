import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] pref = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        long[] all = pref.clone();
        Arrays.sort(all);

        Map<Long, Integer> rank = new HashMap<>();
        int id = 1;

        for (long x : all) {
            if (!rank.containsKey(x)) {
                rank.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id + 2);

        long ans = 0;

        for (long x : pref) {
            int r = rank.get(x);

            ans += bit.query(r - 1);

            bit.update(r, 1);
        }

        return ans;
    }
}

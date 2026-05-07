import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > (n / 2)) {
                return nums[i];
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 7, 7, 8};

        Solution sol = new Solution();
        int ans = sol.majorityElement(arr);

        System.out.println("The Majority Element is " + ans);
    }
}

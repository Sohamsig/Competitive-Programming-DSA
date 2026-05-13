class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int expNum = 0;

        for(int i = 0; i <nums.length; i++) {
            int num =nums[i];

            if(count == 0) {
                expNum = num;
            }

            if(num == expNum) {
                count++;
            }
            else {
                count--;
            }
        }

        return expNum;
    }
}

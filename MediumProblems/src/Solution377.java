import java.util.HashMap;

class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp_table = new int[target+1];
        dp_table[0] = 1;

        for(int i=1; i < dp_table.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp_table[i] += dp_table[i-nums[j]];
                }
            }
        }
        return dp_table[target];

    }
    /*
    Second solution, more memory and slower Time Complexity
     */

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            HashMap<Integer, Integer> targets_found = new HashMap<>();
            System.out.println(targets_found);
            return combinationhelper(nums, target, targets_found);

        }

        public int combinationhelper(int[] nums, int target, HashMap<Integer, Integer> targets_found){
            int res =0 ;

            if (target == 0){
                return 1;
            }
            if (target < 0){
                return 0;
            }
            if (targets_found.containsKey(target)){
                return targets_found.get(target);
            }
            else {
                res = 0;
                for(int i=0; i < nums.length; i++){
                    res += combinationhelper(nums, target - nums[i], targets_found);
                }

            }
            targets_found.put(target, res);
            return res;
        }

    }

}
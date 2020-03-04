

class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x= 0; x<nums.length; x++){
            sum += nums[x];
        }
        if (k == 0 || sum % k != 0 ){
            return false;
        }

        return canPartition(0, nums, k, 0, sum/k, new boolean[nums.length]);
    }

    public boolean canPartition(int cursor, int[] nums, int k, int sumOfPartition, int targetSum, boolean[] used){
        if (k == 1){
            return true;
        }
        if (k > nums.length){
            return false;
        }
        if( sumOfPartition == targetSum ){
            return canPartition(0, nums, k-1, 0, targetSum, used);
        }
        for(int i = cursor; i < nums.length; i++){
            if(!used[i]) {
                used[i] = true;
                if (canPartition(i + 1, nums, k, sumOfPartition + nums[i], targetSum, used)) {
                    return true;
                }
                used[i] = false;
            }

        }
        return false;

    }
}
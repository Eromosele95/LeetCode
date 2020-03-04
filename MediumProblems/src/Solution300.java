import java.util.Arrays;


/**
 * Longest Increasing Subs
 */
class Solution300 {

    public int lengthOfLIS(int[] nums) {
        int[] LIS_array = new int[nums.length];
        Arrays.fill(LIS_array, 1);

        for (int j = 1; j < nums.length; j++) {
            int i = 0; // Starting position for cursor
            while (i < j) {
                if (nums[j] <= nums[i]) {
                    i++;
                }
                else {
                    LIS_array[j] = Math.max(LIS_array[i]+1,
                            LIS_array[j]);
                    i++;
                }
            }
        }
        if(LIS_array.length == 0){
            return 0;
        }
        int max = LIS_array[0];
        for(int z = 1; z < LIS_array.length; z++){
            if(LIS_array[z]> max){
                max = LIS_array[z];
            }
        }
        return max;

    }


    public static void main(String args[]) {

        Solution300 sol = new Solution300();


        System.out.println(sol.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }

}

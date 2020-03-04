
import java.util.Arrays;

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp_table = new int[amount + 1];
        Arrays.fill(dp_table, amount+1);
        dp_table[0] = 0;

        if(amount == 0){
            return 0;
        }
        else{
            for(int i = 1; i < dp_table.length; i++){
                for(int j = 0; j < coins.length; j++){
                    if(i == coins[j]){
                        dp_table[i] = 1;
                    }
                    if(i > coins[j]){
                        dp_table[i] = Math.min(dp_table[i-coins[j]]+1,dp_table[i]);
                    }

                }

            }
        }
        if (dp_table[amount] == amount+1){
            return -1;
        }
        else
        {
            return dp_table[amount];
        }

    }

}

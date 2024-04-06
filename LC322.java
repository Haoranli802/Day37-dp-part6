class Solution {
    public int coinChange(int[] coins, int amount) {
        /**
        dp[j]: dp[j]是能凑成总金额j的最小硬币个数
        初始化，dp[j] = 0 能凑成总金额为0的最小硬币个数为0，其他金额则设为最大数，因为要求最小
        公式：dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        顺序：求组合，所以先物品再背包

        O(N * M), O(M)
         */
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}

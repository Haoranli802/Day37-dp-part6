class Solution {
    public int numSquares(int n) {
        /**
        dp[j]: 总和为j的完全平方数的最小数量
        初始化：dp[j] = 0，其他为最大数
        公式：dp[j] = Math.min(dp[j], dp[j - i*i] + 1)
        顺序：求组合，所以先物品再背包

        O(N * Sqrt(N)), O(N)
         */
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for(int i = 1; i * i <= n; i++){
            for(int j = i * i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
            }
        }
        if(dp[n] == n + 1) return -1;
        return dp[n];
        
    }
}

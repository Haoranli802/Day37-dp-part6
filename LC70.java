class Solution {
    public int climbStairs(int n) {
        return climb(n, 2);
    }
    public int climb(int n, int steps){
        /**
        dp[j]: 有dp[j]种办法爬上j级楼梯
        初始化：有一种办法爬上一级的楼梯
        公式：dp[j] = dp[j] + dp[j - steps]
        顺序：因为是排列问题，先背包再物品
         */
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= steps; j++){
                if(j <= i)
                    dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}

class lcs {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text2.length();
        int n = text1.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    
    }
  public static void main(String args[]){
    String text1 = abbc;
    String text2 = pbbc;
    int ans= longestCommonSubsequence(text1,text2);
    System.out.print("Lcs is : " + ans);
  }

}

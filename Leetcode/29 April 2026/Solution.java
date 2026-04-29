// class Solution {
//        long [][][] store;
//        long [][] colsum;
//        int[][] grid;
//        int n ;
    
//     long solve(int c,int prev,int pprev)
//     {
//         if(c==n) return 0;
//         if(store[c][prev][pprev]!=-1) return store[c][prev][pprev];
//         long maxscore =0;
//         for(int currH =0;currH<=n;currH++)
//         {
//             long currentGain = 0;
//             if(currH<=prev)
//             {
//                 currentGain = colsum[c][prev]-colsum[c][currH];
//             }
//             else
//             {
//                 int startRow = Math.max(prev,pprev);
//                 if(currH > startRow)
//                 {
//                     currentGain = colsum[c-1][currH]-colsum[c-1][startRow];
//                 }
//             }
//             long result  = currentGain + solve(c+1,currH,prev);
//             maxscore = Math.max(maxscore,result);
//         }
//         return store[c][prev][pprev] = maxscore;
//     }
//     public long maximumScore(int[][] grid) {
//         this.grid = grid;
//           this.n = grid.length;
//          colsum = new long[n][n+1];
       
//         for(int i=0;i<n;i++)
//         {
//             for(int j =1;j<=n;j++)
//             {
//                 colsum[i][j]=colsum[i][j-1]+grid[j-1][i];
//             }
//         }
//       store = new  long[n][n+1][n+1];
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<=n;j++)
//             {
//                 Arrays.fill(store[i][j],-1);
//             }
//         }
//         long ans =0;
//         for(int i=0;i<=n;i++)
//         {
//             ans = Math.max(ans,solve(1,i,0));
//         }
//         return ans;
//     }
// }.
class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        
        long[][] colsum = new long[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                colsum[i][j] = colsum[i][j - 1] + grid[j - 1][i];
            }
        }
        
        long[] prevPick = new long[n + 1];
        long[] prevSkip = new long[n + 1];
        
        for (int c = 1; c < n; c++) {
            long[] currPick = new long[n + 1];
            long[] currSkip = new long[n + 1];
            
            for (int currH = 0; currH <= n; currH++) {
                for (int prevH = 0; prevH <= n; prevH++) {
                    
                    if (currH > prevH) {
                        
                        long score = colsum[c - 1][currH] - colsum[c - 1][prevH];
                        
                        currPick[currH] = Math.max(currPick[currH], prevSkip[prevH] + score);
                        currSkip[currH] = Math.max(currSkip[currH], prevSkip[prevH] + score);
                        
                    } else {
                       
                        long score = colsum[c][prevH] - colsum[c][currH];
                       
                        currPick[currH] = Math.max(currPick[currH], prevPick[prevH] + score);
                        currSkip[currH] = Math.max(currSkip[currH], prevPick[prevH]);
                    }
                }
            }
            
            prevPick = currPick;
            prevSkip = currSkip;
        }
        
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, prevPick[i]);
        }
        
        return ans;
    }
}
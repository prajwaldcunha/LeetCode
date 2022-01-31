class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0, currMax=0;
        
        for(int i=0;i<accounts.length;i++) {
            currMax=0;
            for(int j=0;j<accounts[0].length;j++){
                currMax = currMax+accounts[i][j];
            }
            max=Math.max(max, currMax);
        }
        
        return max;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        
        int sum=0;
        for(int i=1;i<=numRows;i++){
            List<Integer> temp=new ArrayList<>();
            
            for(int j=1;j<=i;j++){
                if(j==1||j==i){
                    temp.add(1);
                }
                else{
                    sum=res.get(i-2).get(j-1)+res.get(i-2).get(j-2);
                    temp.add(sum);
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List  <List<Integer>> result = new ArrayList<>();
        if(numRows==0) return result;
        ArrayList <Integer> frow= new ArrayList <>();
        frow.add(1);
        result.add(frow);
        if(numRows==1) return result;
        for(int i=1;i<numRows;i++){
        List <Integer> pr=result.get(i-1);
        ArrayList <Integer> row =new ArrayList <>();
        row.add(1);
        for(int j=0;j<i-1;j++){
            row.add(pr.get(j)+pr.get(j+1));
        }
        row.add(1);
        result.add(row);
        }
        return result;
    }
}

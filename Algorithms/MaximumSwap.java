class Solution {

    public int maximumSwap(int num) {
     String te = Integer.toString(num);
int[] a = new int[te.length()];
for (int i = 0; i < te.length(); i++)
{
    a[i] = te.charAt(i) - '0';
}

       for(int i=0;i<a.length-1;i++){
        int max =0;
        int temp =0;
        for(int j=i;j<a.length;j++){
            max = Math.max(max,a[j]);
            if(a[j] == max){
                temp = j;
            }
        }
        if(a[i]<max){
            int t= a[i];
            a[i] = a[temp];
            a[temp] = t;
            break;
        }

       }
       int ans =0;
       for(int i=0; i<a.length;i++){
        ans= 10* ans + a[i];
       }
    
    return ans;
    }
}

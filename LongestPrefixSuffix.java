//longest prefix suffix by KMP Algorithm
// input String - ABCDAABBCABCD
//returns the longest number of characters of longest prefix which is also suffix
//Get the output by typing -> [java LongestPrefixSuffix ] in the terminal

class LongestPrefixSuffix{
    public static void main(String args[]){
    KMP obj = new KMP();
    int a = obj.lpsArray("ABCDAABBCABCD");
    System.out.println(a);
    }
}

class KMP{
    int lpsArray(String s){
        int n =s.length();
        char a[] = s.toCharArray();

        int lps[] = new int[n];
        int pre=0;
        int suf=1;
        while(suf<n){
            if(a[pre]==a[suf]){
                lps[suf] = pre+1;
                pre++;
                suf++;
            }
            else{
                if(pre==0){
                    lps[suf] = pre;
                    suf++;
                }
                else{
                    pre = lps[pre-1];
                }
            }
        }
        return lps[n-1];
} 
}



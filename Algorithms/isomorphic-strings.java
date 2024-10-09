class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())  return false;
        HashMap <Character,Character> hm=new HashMap<> ();
        for(int i=0;i<s.length();i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            if(hm.containsKey(schar)){
                if(hm.get(schar)!=tchar)
                {
                return false;
                }
            }
            else {
                if(hm.containsValue(tchar)){
                     return false;
                }
            hm.put(schar,tchar);
            }
        }
        return true;
    }
}

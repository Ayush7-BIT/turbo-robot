public class MergSort {
   
    static void sortM(int arr[],int i,int m,int l){
      int pre[]=new int[m-i+1];
      int sec[]=new int[l-m];
      int k=0;
      for(int o=i;o<m+1;o++){
        pre[k]=arr[o];
        k++;
      }
      k=0;
      for(int o=m+1;o<=l;o++){
        sec[k]=arr[o];
        k++;
      }
      if(pre.length>sec.length)
       {
        int srr[]=pre;
        pre=sec;
        sec=srr;
       }
      // System.out.println(pre.length);
       //System.out.println(sec.length);
      k=0;
     int v=0;
     int ma=i;
    while(k<pre.length&&v<sec.length){
if(pre[k]<sec[v]){
  arr[ma]=pre[k];
  ma++;
  k++;
}
else if(sec[v]<=pre[k]){
  arr[ma]=sec[v];
 
  ma++;
 
  v++;
}
    }
    if(k==pre.length){
      while (v<sec.length) {
        arr[ma]=sec[v];
        v++;
        ma++;
      }
    }
    else if(v==sec.length){
      while (k<pre.length) {
        arr[ma]=pre[k];
        k++;
        ma++;
      }
    }

    }

    static void Mrecsort(int arr[],int i,int l){
       
        int m=(i+l)/2;
       
        if(i<l){

      Mrecsort(arr, i,m );
      
      Mrecsort(arr, m+1, l);
      sortM(arr,i,m,l);
        }
        
    } 
    public static void main(String[] args) {
        int arr[]={3,1,2,4,1,5,2,6,4};
        Mrecsort(arr,0,arr.length-1);
        for (int arr2 : arr) {
            System.out.print(arr2);
        }
        
    }
}
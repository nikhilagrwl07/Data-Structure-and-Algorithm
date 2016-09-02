
package TernerySearch;

public class TernerySearch {
    
    public static void main(String[] args) {

        int a[]={1,2,3,4,5,6,7,8};
        
        int indexFound = ternaerySearch(a,0,a.length-1, 2);
        if(indexFound!=-1)
        {
            System.out.println("element found at index :: " + indexFound);
        }
        else
        {
             System.out.println("element NOT found");
        }
         
         
    }
    
    public static int ternaerySearch (int[] a , int l , int r ,int value)
    {
        
        if(r<l){
            return -1;
        }
         
        int mid1 = l + (r-l)/3;
        int mid2= mid1+(r-l)/3;
        
        if(a[mid1] == value) 
        {
            return mid1;
        }
        if(a[mid2] == value) 
        {
            return mid2;
        }
        
        if(value<a[mid1])
           return ternaerySearch(a, l, mid1-1, value);
        else if(value>a[mid1] && value < a[mid2])
           return ternaerySearch(a, mid1+1, mid2-1, value);
        else
            return ternaerySearch(a, mid2+1, r, value);
            
        }
    

}

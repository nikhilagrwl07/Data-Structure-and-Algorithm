package occurence;

public class Occurence {

    public static void main(String[] args) {

        int a[] = {1, 1, 1, 1,2, 2,  2, 3, 3, 4, 4, 5, 5, 5, 7, 18, 18};

//        System.out.println("first occ. " + BinarySearchFirstOccurence(a, 0, a.length - 1, 5));
//        System.out.println("last occ. " + BinarySearchLastOccurence(a, 0, a.length - 1, 2));
        
//        int b[] = {2,4,4,4,4,6,8,10,12,14,16};
//        System.out.println("crossOverPoint : " + crossOverPoint(a, 0, a.length - 1, 10));
        
        System.out.println("findSmallerElementEvenElementIsNotPresent :: " + findSmallerElementEvenElementIsNotPresent(a, 0, a.length - 1, 18,0,a.length-1));
        
    }

    public static int BinarySearchFirstOccurence(int a[], int l, int h, int data) {


        if (h >= l) {
            int mid = l + (h - l) / 2;
            System.out.println(l + " : " + mid + " : " + h);    
            if ((mid == l && a[mid] == data) || (a[mid] == data && a[mid - 1] < data)) 
            {
                return mid;
            } 
            else if (a[mid] >= data) 
            {
                return BinarySearchFirstOccurence(a, l, mid - 1, data);
            } 
            else 
            {
                return BinarySearchFirstOccurence(a, mid + 1, h, data);
            }
        }
        return -1;

    }
    
     public static int BinarySearchLastOccurence(int a[], int l, int h, int data) {


        if (h >= l) {
            int mid = l + (h - l) / 2;
            System.out.println(l + " : " + mid + " : " + h);

            if ((mid == h && a[mid] == data) || (a[mid] == data && a[mid + 1] > data)) 
            {
                return mid;
            } 
            else if (a[mid] > data) 
            {
             //   System.out.println("Inside 123");
                return BinarySearchLastOccurence(a, l, mid - 1, data);
            } 
            else 
            {
               // System.out.println("Inside 234");
                return BinarySearchLastOccurence(a, mid + 1, h, data);
            }
        }
        return -1;

    }
     
     
      public static int findSmallerElementEvenElementIsNotPresent(int a[],int l,int h,int d,int strt,int end)
     {
         if(l<=h)
         {
         if(d>a[end])
             return a[end];
         
         if(d<a[strt])
             return -1;
         
         int mid=l+(h-l)/2;
//             System.out.println("mid "+ mid);

         if(mid==strt && a[mid]==d)
             return -1;

         if(mid==l && d<a[mid])
             return a[mid-1];

         if(mid==h && d>a[mid])
             return a[mid];
         
         if(a[mid]==d && a[mid-1]!=d)
             return a[mid-1];
         
         
         else if(d<=a[mid])
             return findSmallerElementEvenElementIsNotPresent(a, l, mid-1, d,strt,end);
         else
             return findSmallerElementEvenElementIsNotPresent(a, mid+1, h, d,strt,end);
         }
         
         return -1;
     }
      
     
     public static int crossOverPoint(int a[], int l  , int h , int x)
     {
         
         if(l>h) 
             return -1;
         
         if(a[h]<=x)
             return h;
         
         if(x<a[l])
             return l;
         
         
         int mid = l + (h-l)/2;
         System.out.println(l + " : " + mid + " : " + h);
         
         if(a[mid]<=x && a[mid+1]>x)
         {
             return mid;
         }
         if(a[mid]<=x)
         {
             return crossOverPoint(a, mid+1, h, x);
         }
         else
         {
            return crossOverPoint(a,l, mid-1, x); 
         }
     }
}

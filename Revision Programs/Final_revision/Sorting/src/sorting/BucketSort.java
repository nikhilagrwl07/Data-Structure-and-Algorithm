
package sorting;

public class BucketSort{

    public static void sort(int[] a, int maxVal){
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++){
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++){
            bucket[a[i]]++;
        }

        printout(bucket,bucket.length , "Buckets ");

        int outPos=0;
        for (int i=0; i<bucket.length; i++){
            for (int j=0; j<bucket[i]; j++){
                a[outPos++]=i;
            }
        }
    }

    
    public static void main(String[] args){
        int maxVal=3;
        int [] data= {1,0,1,2,3,1,0,3,1,0,1,3}; //ArrayUtil.randomIntArray(10,maxVal+1);

        printout(data, data.length, "Initial input array");

        sort(data,maxVal);

           printout(data, data.length, "Sorted input array");

    }
    
      public static void printout(int a[],int r,String s)
    {
        System.out.println(s);
        for(int i=0;i<r;i++)
            System.out.print(a[i]+"  ");
        
        System.out.println();
    }

}
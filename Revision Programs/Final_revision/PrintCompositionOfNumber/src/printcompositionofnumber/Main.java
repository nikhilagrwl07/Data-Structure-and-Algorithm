
package printcompositionofnumber;

/**
 *
 * @author nikhil.agrawal
 */
public class Main {

    static int ARR_SIZE =5;
    static int MAX_POINT =5;
    static int[] composition;
    public static void main(String[] args) {
       composition = new int[ARR_SIZE];
        int sum=5;
       int startIndex=0;
       printcomposition(sum,startIndex);
        
    }
    
    static void printcomposition(int sum , int index){
        
        if(sum == 0){
            printArray(composition, index);
        }
        else if(sum>0)
        {
            
            for(int i=1;i<=MAX_POINT;i++)
            {
                composition[index]=i;
                printcomposition(sum-i, index+1);
            }
        }
    }
    
    
    public static void printArray(int a[], int index){
        
        System.out.println("");
        for(int i=0;i<index;i++)
        {
            System.out.print(a[i] + " ");
        }
        
    }

}

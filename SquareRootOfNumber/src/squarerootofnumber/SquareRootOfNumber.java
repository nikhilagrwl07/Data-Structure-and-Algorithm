
package squarerootofnumber;

public class SquareRootOfNumber {

    
    public static void main(String[] args) {
      double b3=0.505050;
      
      System.out.println("Method 1: Sqrt of "+b3+" = "+sqrtMethod1(b3));
        System.out.println("Method 3: Sqrt of "+b3+" = "+sqrtMethod3(b3));  
    }
    
    // Source: https://codeanyway.quora.com/Square-Root-without-using-inbuilt-functions
    // O(Sqrt(n)) : Naive Method
    public static double sqrtMethod1(double n)
    {
        double i,precision=0.0001;
        
            for(i=1;i*i<n;i++); // Integer part
            
            //System.out.println("Integer part = "+i);
                
            for(--i;i*i<n;i+=precision);  // didn't understod about fractional part
              //  System.out.println("Fractional part = "+i); // Fractional part 
            
            return i;
    }
    
      
    //Source: http://justalgorithmlogic.blogspot.in/2013/07/find-square-root-of-number-using-binary.html
    // Binary Search Method
    public static double sqrtMethod3(double a)
    {
        //firstly check if a is non-negative value
    if(a<0)
        return -1;
    
    //also check if a==0 or a==1 because in these two cases sqrt(a) = a
    if(a==0 || a==1) return a;

    //now start the core part of the code
    double precision = 0.0000000000001;//define the precision, so we stop when precision is achieved
    
    double start = 0;
    double end = a;
    
    //we define these two start/end values because usually 0<sqrt(a)<a
    //however, if a<1; then 0<a<sqrt(a)
    if(a<1)
        end = 1;

    //define a loop to continue if the precision is not yet achieved
    while(end-start>precision)
    {
       // System.out.println("end-start = "+(end-start));
      //  System.out.println("precision = "+precision);

    double mid = (start+end)/2;
    double midSqr = mid*mid;
    
    if(midSqr==a)
        return mid;//we find the exact sqrt value!
    else if(midSqr<a)
        start = mid;//we shift our focus to bigger half
    else 
        end = mid;//shift focus to smaller half
    }

    
    //if we did not find exact sqrt value, we return the approxiated value with the defined precision
    return (start+end)/2;
   
  }   
}

//Name - Nikhil Agrawal
// ID - 200901160

package queueingnetwork;

/**
 *
 * @author NIKHIL AGARAWAL
 */
public class QueueingNetwork {

    public static void main(String[] args) {
        
        int r[]=new int[3];
        
        int t,total_rate=0;
        // Considering number of student as capacity
         int capacity=99999;  
        r[0]=5;
        r[1]=10;
        r[2]=15;
     
        double s[]=new double[3];
         s[0]=10;
        s[1]=50;
        s[2]=100;
        
        double a[]=new double[3];
      
       
        double average_number_of_customers=0,temp=0;
        
       System.out.println("Parameters given in the question are as follows: ");
        System.out.println("Customers arrive at stations 1,2,3 in accordance to a Poisson process having respective rates "+r[0]+" "+r[1]+" "+r[2]);
        System.out.println("The service times at the three stations are exponential with respective rates "+s[0]+" "+s[1]+" "+s[2]);
     
        // Now calculating the respective λ's
        // Formula for λ's
        
        // λ1=r1;
        a[0]=r[0];       
        
        
        //λ2=r2+1/3*λ1+1/2*λ3
        a[1]=35+a[0];
        
        //λ3=r3+1/3*λ1+λ2
        float z=(float) 4/3;
        //System.out.println("check ="+z);
        a[2]=50.0 +(z*a[0]);
        
        //System.out.println("λ1="+λ[0]);
        //System.out.println("λ2="+λ[1]);
        //System.out.println("λ3="+λ[2]);
        
        // Formula used for Average number of customers
        //average_number_of_customers=Σ λi/(Si-λi)
        
        for(t=0;t<3;t++)
        {
            temp=a[t]/(s[t]-a[t]);
            average_number_of_customers +=temp;
        }
        
        int avg=(int) average_number_of_customers;
       System.out.println("True value of average number of customers="+avg);
       
       
       int i,j;
                 double sum=0;
        double value=0;
       
        for(j=0;j<3;j++)
         {
            value=0;        
         for(i=1;i<=capacity;i++)
         {
              double v1=(double) Math.pow(a[j]/s[j],i);
             value=value+(i*v1);
          
         }
         
         sum=sum+(value*(double)(1.0-(double)(a[j]/s[j])));
         }
         
        System.out.println("Analytical value of average number of customers="+sum);
        
        
         for(t=0;t<3;t++)
         total_rate +=r[t];
         
         double Average_time_customer=average_number_of_customers/total_rate;
     
         System.out.println("True value of Average time a customer spends in the system="+Average_time_customer);
         
         
         // Solving it by simulation
         
         
         //Solving it by simulation of avg waiting time of the customer
         double waiting_time=0.0;
         double sum_new=0;
         for(i=0;i<3;i++)
         {
             double t2=s[i]-r[i];
           
             double t3=(double) 1.0/t2;
             
             waiting_time +=t3;
         }
      System.out.println(" Analytical value of Average time a customer spends in the system="+ waiting_time);
         double sum1=0;
          for(j=0;j<3;j++)
         {
            value=0;        
         for(i=1;i<=capacity;i++)
         {
              double v1=(double) Math.pow(a[j]/s[j],i);
             value=value+(i*i*v1);
          
         }
         
         sum1=sum1+(value*(1-a[j]/s[j]));
         }
          
          double f=sum1-sum;
          double p=Math.sqrt(f);
          double k=Math.sqrt(capacity);
          double l=sum-((1.96*p)/k);
          double u=sum+((1.96*p)/k);
          System.out.println("Interval limit="+(u-l));
          
          
          double error=waiting_time-Average_time_customer;
       //System.out.println("Error = "+error);
          
       //System.out.println("Value "+error/0.1);
          
          // System.out.println("Error = "+error);
           
           
           
    }
    
    
    
}

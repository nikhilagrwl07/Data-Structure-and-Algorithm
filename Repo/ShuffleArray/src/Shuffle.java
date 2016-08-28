import java.util.Random;


public class Shuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		 printArray(arr);
		 randomize(arr);
		 printArray(arr);	
		 
	}
	
	public static void randomize(int a[])
	{
		//Fisher–Yates shuffle Algorithm works in O(n) time complexity.
		
		//for(int i=a.length-1;i>=0;i--)
		for(int i=a.length-1;i>=0;i--)
		{
			Random rgen=new Random();
			int randomPosition=rgen.nextInt(i+1);
			
			// randomly generating number from 0 to i
			//int j=(int)Math.random()%(i+1);
						
			int t=a[randomPosition];
			a[randomPosition]=a[i];
			a[i]=t;
		}
	}
	
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"  ");
		
		System.out.println();
	}
	

}

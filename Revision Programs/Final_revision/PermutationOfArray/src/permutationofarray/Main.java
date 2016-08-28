
package permutationofarray;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int a[]={0,2,3};
        Main m = new  Main();
        System.out.println(m.permuteUnique(a));
        
    }
    
    public int permuteUnique(int[] num) {
        
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
	permuteUnique(num, 0, result);
          
        int sum = sumOf4digitNumber(result);
	return sum;
}
    
    public int sumOf4digitNumber(ArrayList<ArrayList<Integer>> result){
       // System.out.println("sunze = " + result.size());
        int sum =0 ;
        for(int i=0 ; i<result.size();i++)
        {
            ArrayList<Integer> numb = result.get(i);
            
            int number = getNumber(numb);
            System.out.println("number :: " + number);
   
            sum +=number;
        }
        return sum;
       
        
    }
    
    public int getNumber(ArrayList<Integer> al){
       // 
        //System.out.println("list :: " + al.toString());
        int sum =0;
        int pow =3;

       for(Integer e : al)
       {
           if(pow==3 && e==0 ) 
               return 0;
           
           sum = (int) (sum + (Math.pow(10, pow)*e));
           pow--;
       }
       // System.out.println("conveted number  :: " + sum); 
       return sum;
        
    }
//    
    private void permuteUnique(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
 
	if (start >= num.length) {
            
		ArrayList<Integer> item = convertArrayToList(num);
              //  System.out.println("number :: " + item.toString());
		result.add(item);
	}
 
	for (int j = start; j <= num.length-1; j++) {
		if (!containsDuplicate(num, start, j)) {
			swap(num, start, j);
			permuteUnique(num, start + 1, result);
			swap(num, start, j);
		}
	}
        
}
    
    private ArrayList<Integer> convertArrayToList(int[] num) {
	ArrayList<Integer> item = new ArrayList<Integer>();
	for (int h = 0; h < num.length; h++) {
		item.add(num[h]);
	}
	return item;
}
 
private boolean containsDuplicate(int[] arr, int start, int end) {
	for (int i = start; i <= end-1; i++) {
		if (arr[i] == arr[end]) {
			return true;
		}
	}
	return false;
}
 
private void swap(int[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}
    

}

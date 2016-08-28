package stringalgorithm;

/**
 *
 * @author nikhil.agrawal
 */
public class formingSentenceUsingWordsFromEachRow {
    
    public static final int row = 3, col =3;
    
    public static void main(String[] args) {

        String[][] s = { {"India" , "USA" , "Cannada"},
                            {"delhi" , "UP" , "NY"},
                            {"Ghazipur","Varansi","Square Garden"}   
                              };
        
//        String ans[] = new String[row];
//        
//        for(int i=0;i<col;i++)
//        {
//            if(!s[0][i].isEmpty() && s[0][i]!=null)
//            {
//                printUtil(s, 0, i, ans);
//            }
//        }
        
        printEasy(s, "", 0);
    }
    
    public static void printUtil(String[][] s , int r , int c , String[] ans)
    {
        
        ans[r]=s[r][c];
        
        if(r==row-1)
        {
            for(int i=0;i<=row-1;i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println("");
            return;
        }
        
        
        for(int i=0; i<col;i++)
        {
            if(s[r+1][i]!=null && !s[r+1][i].isEmpty())
            {
                printUtil(s, r+1, i, ans);
            }
        }
        
//        System.out.println("-----------End Of  recursion---------- ");
        
    }
    
    
   public static void printEasy(String[][] s, String sen, int r) {
       
//       System.out.println("r = " + r);
	if(r == row) 
        {
            System.out.println(sen);
		return;
	}
 
	for(int i = 0; i < col; i++) 
        {
            printEasy(s, sen + " " + s[r][i], r+1);
	} 
}


}

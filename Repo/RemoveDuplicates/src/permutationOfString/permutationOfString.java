
package permutationOfString;

public class permutationOfString {
    
    public static void main(String[] args) {
        char[] s = "ABC".toCharArray();
        permutate(s, 0, s.length);
    }
    
    public static void swap(char[] c, int x ,int y){
        char t= c[x];
        c[x]=c[y];
        c[y]=t;
    }

    public static void permutate(char[] c , int s, int e){
        System.out.println("s="+ s+ " e="+e);    
        if(s==e){
               System.out.println(c);
            }
                //
            else{
                for(int i=s;i<e;i++){
                    swap(c, i, s);
        //            System.out.println(c);
                    permutate(c, s+1, e);
                    swap(c, i, s);
                }
            }

    }

}



package codechef_pratice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(in.readLine());
        
        while(t-- >0){
            String input[]= in.readLine().split(" ");
            int n= Integer.parseInt(input[0]);
            int k= Integer.parseInt(input[1]);
            int i;
            String s = in.readLine();

            // Case 2 : when k=1
            if(k==1){
                char[] i1 = new char[n+1];
                char[] i2= new char[n+1];
                
                int m1=0,m2=0;
                for(i=0;i<n;i=i+2)
                {
                    i1[i]='0';
                    i2[i]='1';
                }
                for(i=1;i<n;i=i+2)
                {
                    i1[i]='1';
                    i2[i]='0';
                }

                for(i=0;i<n;i++){
                  if(s.charAt(i)!=i1[i])
                      m1++;
                  if(s.charAt(i)!=i2[i])
                      m2++;
              }

                if(m1<m2){
                    out.write(m1+"\n");
                for(i=0;i<n;i++)
                {
                    out.write(i1[i]);
                }
                    out.write("\n");
                }
                else{
                    out.write(m2+"\n");
                    for(i=0;i<n;i++)
                {
                    out.write(i2[i]);
                }
                    out.write("\n");
                }
            }
            
            else // case 2 : k>1
            {
                char prev='x'; int count =0,nof =0;
                StringBuilder sb = new StringBuilder(s);
                for(i=0;i<n;i++){
                    if(sb.charAt(i) == prev){
                        count++;
                    }
                    else
                    {
                        count =1;
                    }

                    if(count>k){
                       if (i + 1 < sb.length() && sb.charAt(i+1) != sb.charAt(i)) {
                            //flip i-1
        		             char c = sb.charAt(i - 1)=='0'?'1' : '0';
        		             sb.setCharAt(i - 1, c);
                        } else {
                            //flip i
        		             char c = sb.charAt(i)=='0'?'1' : '0';
        		             sb.setCharAt(i, c);
                        }
		             count=1;nof++;
                    }
                    prev = sb.charAt(i);
                }
                 out.write(nof+"\n");
	        out.write(sb.toString()+"\n");
            }
        }
        out.flush();
    }

}


package stringregex;


public class StringRegex {

    public static void main(String[] args) {
        String reg="^aa";
        String pat="abab";
        
            //System.out.println(reg.length());
            
        if(match(reg,pat))
        {
            System.out.println("Matching");
        }
        else
            System.out.println("NOT Matching");
        
    }
    
    
    public static boolean match(String regex,String pat)
    {
        
       if(regex.length()==0 && pat.length()>0)//      !=null)
       {
           return false;
       }
       
      if(regex.length()==0 && pat.length()==0)
       {
           return true;
       }
        
     // System.out.println(match$(regex, pat)+" hcekc");
      
      char[] reg=regex.toCharArray();
      
      if(reg[reg.length-1]=='$')
      {
          return match$(regex, pat);
      }

      if(reg[0]=='^')
      {
          return matchPower(regex, pat);
      }
     
      
       if(containDot(regex, pat)==true)
       {
               System.out.println("check DOT ");
           return matchDot(regex, pat);
       }
       
        if(containStar(regex, pat)==true)
       {
           System.out.println("check");
           return matchStar(regex, pat);
       }
       
            
      // return true;
//       // only alphabets case
     //  if(matchAlph(regex, pat)==true)
      // {
           return matchAlph(regex, pat);
       //{;
       
    }
    
    public static boolean match$(String regex,String pat)
    {
        char reg[]=regex.toCharArray();
        char[] pt=pat.toCharArray();
        int len=reg.length;
        
        if(reg[len-1]=='$')
        {
           // System.out.println("check");
            
            if(len==1)
            {
                if(pat==null)
                    return true;
                else
                    return false;
            }
            
            // all rest of cases
            int j;
            int len_pat=pat.length();
            
            for(j=len-2;j>=0 && pat.length()>=len-1;j--)
            {
                if(reg[j]!=pt[len_pat-1]) //reg[j]==pat[len_pat-1]
                {
                   return false;
                }
                System.out.println(reg[j]+" "+ pt[len_pat-1]);
                      len_pat--;          
            }
           // if(j==0)
                return true;            
        }
        
        return true;
    }

     public static boolean matchPower(String regex,String pat)
    {
        char reg[]=regex.toCharArray();
        char[] pt=pat.toCharArray();
        int len=reg.length;
        
        if(reg[0]=='^')
        {
            if(len==1)
            {
                if(pat==null)
                    return true;
                else
                    return false;
            }
            
            // all rest of cases
            int j;
            int len_pat=pat.length();
            int k_pat=0;
            
            for(j=1;j<=len-1 && pat.length()>=len_pat;j++)
            {
                if(reg[j]!=pt[k_pat]) //reg[j]==pat[len_pat-1]
                {
                   return false;
                }
                                
               k_pat++; 
            }
           // if(j==len)
                return true;            
        }
        
        return true;
    }

    public static boolean containDot(String regex,String pat)
    {
         char[] reg=regex.toCharArray();
        char[] pt=pat.toCharArray();
        
    
         for(int i=0;i<reg.length;i++)
        {
            if(reg[i]=='.')
            {
                return true;
            }
        }
         return false;
    }
    public static boolean matchDot(String regex,String pat)
    {
        char[] reg=regex.toCharArray();
        char[] pt=pat.toCharArray();
        
        int len_reg=reg.length;
        int len_pat=pt.length;
        
        if(len_pat!=len_reg)
        {
            return false;
        }
               
        //int i=0;
        for(int i=0;i<len_reg;i++)
        {
            if(reg[i]!='.')
            {
                if(reg[i]!=pt[i])
                {
                    return false;
                }
             }
            else
            {
               // i++;
            }
            
        }
        return true;
    }

    public static boolean containStar(String regex,String pat)
    {
         char[] reg=regex.toCharArray();
        char[] pt=pat.toCharArray();
        
    
         for(int i=0;i<reg.length;i++)
        {
            if(reg[i]=='*')
            {
                return true;
            }
        }
         return false;
    }
    
    public static boolean matchStar(String regex,String pat)
    {
        char reg[]=regex.toCharArray();
        char[] pt=pat.toCharArray();
        
        int reg_len=reg.length;
        int pt_len=pt.length;
        
        if(reg[0]=='*')
            return false;
        
        int i;
        
        for(i=0;i<reg_len;i++)
        {
            // matching the prefix to *
            if(reg[i]!='*')
            {
                if(reg[i]!=pt[i])
                {
                    return false;
                }
            }
            else
            {
                break;
            }
            
        }
        
        // matching the suffix now
        // means * star occuring at the end
        if(i==reg_len)
        {
            int k=i-1;
            // check all value after i in pt
            while(i<pt_len && pt[i]==reg[k])
            {
                i++;
            }
            
            if(i==pt_len)
                return true;
            else
                return false;
        }
        else
        {
          // * is occuring in middle of string matching the suffix
          int k=i;
          int r=reg_len-1;
          int pt_var=pt_len-1;
          
          while(r>k)
          {
              if(pt[pt_var]==reg[r])
              {
                  pt_var--;
                  r--;
                  //continue;
              }
              else
                  break;
          }
          
          // case 1: when * gives null position
               if(pt_var==i)     
               {
                   return true;
               }
          
          // Case 2: when * gives repetition
               while(pt_var>=i)
               {
                   if(pt[pt_var]!=reg[i-1])
                       return false;
                   else
                       pt_var--;
               }
                
           return true;    
        }
        
    }
   
    public static boolean matchAlph(String regex,String pat)
    {
        char reg[]=regex.toCharArray();
        char[] pt=pat.toCharArray();
        
         int len_reg=reg.length;
        int len_pat=pt.length;
        
        if(len_pat!=len_reg)
        {
            return false;
        }
        
        for(int i=0;i<len_reg;i++)
        {
            if(reg[i]!=pt[i])// && reg[i]!='.' && reg[i]!='*' && reg[i]!='^' && reg[i]!='$')
            {
                return false;
            }
            
        }
        
        return true;
    }

   
}

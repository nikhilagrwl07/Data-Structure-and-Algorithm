
package anagrams;

import java.util.*;
import java.io.*;
import java.net.*;

public class Anagrams
{
	public static void main(String[] args) throws IOException
	{
		URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
		Scanner sc = new Scanner( url.openStream() );

		HashMap<String, ArrayList<String>> map =  new HashMap<String, ArrayList<String>>();

		while( sc.hasNextLine() )
		{
			String word = sc.nextLine();
               
			String sortedWord = sortString(word); // this is a key

			ArrayList<String> anagrams = map.get( sortedWord );  //this is a value

			if( anagrams == null ) anagrams = new ArrayList<String>();

			anagrams.add(word);
			map.put(sortedWord, anagrams);
		}
                
              
                    //  int n=20;
                
                    for(String key : map.keySet())
                    {
                        System.out.println(map.get(key));
                        
                            System.out.println("---------------");
                      //  if(n==0)
                        //    break;
                        
                       // n--;
                    }
                    
                    
		//System.out.println(map.get(sortString("bread")));   //testing

	}
        
	private static String sortString( String w )
	{
		char[] ch = w.toCharArray();
		//Arrays.sort(ch);
                Arrays.sort(ch);
            return new String(ch);
	}
}

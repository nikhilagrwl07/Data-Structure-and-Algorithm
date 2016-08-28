
package bufferedreaderexample;


import java.io.*;
import java.util.Scanner;
 
public class BufferedReaderExample {
 
	public static void main(String[] args) throws FileNotFoundException {
 
//		BufferedReader br = null;
// 
//		try {
// 
//			String sCurrentLine;
//                         String fname="C:\\Users\\N1K$$\\Desktop\\dict.txt";
//			br = new BufferedReader(new FileReader(fname));
// 
//			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
//			}
// 
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null)br.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
            
            String str="C:\\Users\\N1K$$\\Desktop\\dict.txt";
            
            File fname=new File(str);
             FileReader fr = new FileReader(fname);
             
               
            Scanner scanner = new Scanner(fr);
while (scanner.hasNextLine()) {
    String nextToken = scanner.next();
    System.out.println(nextToken);
 
	}
}
}
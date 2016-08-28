
package codechef_pratice;

import java.util.*;
public final class Test1
{

    static int m1,m2,flag=0,a,b;

	public static void main(String arg[])
	{
		Scanner br=new Scanner(System.in);
		 a=br.nextInt();
		 b=br.nextInt();
		int l1=br.nextInt();
		int b1=br.nextInt();
		int l2=br.nextInt();
		int b2=br.nextInt();
		m1=Math.max(l1,l2);
		m2=b1+b2;
		set();
		m1=Math.max(l1,b2);
		m2=b1+l2;
		set();
		m1=Math.max(b1,l2);
		m2=l1+b2;
		set();
		m1=Math.max(b1,b2);
		m2=l1+l2;
		set();
		if(flag==1)
			System.out.print("YES");
		else
			System.out.print("NO");

	}
	public static void set()
	{
		if((m1<=a && m2<=b)||(m1<=b && m2<=a))
			flag=1;
			return ;
	}
}

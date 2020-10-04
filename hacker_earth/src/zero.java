import java.math.BigInteger;
import java.util.Scanner;

public class zero {
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
        long m = sc.nextLong();
        String s1="";
        String s2="";

        boolean no=false;

        StringBuilder sb=new StringBuilder();
        if((n+2)<m/2||n>(m+1))
        {
            n=0;
            m=0;
            no=true;
        }
        for(int i=0;m>0&&n>0;i++)
        {
         if((m-2)>=(n-1))
         {
             sb.append("110");
             m-=2;
             n--;
         }
         else
         {
             sb.append("10");
             m--;
             n--;
         }
        }
        if(m==2)
        {
            sb.append("11");
            m-=2;
        }
        if(m==1)
        {
            m--;
            sb.append("1");
        }
        if(n==1)
        {
            String s=sb.toString();
            sb.delete(0,s.length());
            sb.append("0"+s);
            n--;
        }
      // System.out.println(sb);
        if(m>0||n>0||no)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(sb.toString());
        }
    }
}

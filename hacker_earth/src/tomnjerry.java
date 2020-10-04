import java.math.BigInteger;
import java.util.Scanner;

public class tomnjerry {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            long n = sc.nextLong();
            if(n%2==0)
            {
            while(n>0&&n%2==0)
            {
                n=n>>1;
            }
            }
            long count =n/2;
            sb.append(count+"\n");
        }
        System.out.println(sb.toString());
    }

}

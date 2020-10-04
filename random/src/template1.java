import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class template1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max=(int)1e8+30;
        boolean a[] = new boolean[max+1];
        Arrays.fill(a,true);
        a[0]=a[1]=false;

        for(int i=2;(long)i*(long)i<=max;i++)
        {
            if(a[i])
            {
                for(int j=i*i;j<=max;j+=i)
                {
                    a[j]=false;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=max&&n>0;i++)
        {
            if(a[i])
            {
                n--;
                sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class coins {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            int n=sc.nextInt();
            int ar[]=new int[n];
            HashMap<Integer,Integer> h1=new HashMap<>();
            h1.put(5,0);
            h1.put(10,0);
            h1.put(15,0);
            for(int i=0;i<n;i++)
            {
                ar[i]=sc.nextInt();
                h1.put(ar[i],h1.get(ar[i])+1);
            }
            int count5=0;
            int count10=0;

            int f=0;
            if(h1.get(15)==0)
            {
                for (int i = 0; i < n; i++) {
                    int cur = ar[i];
                    cur = cur - 5;
                    cur /= 5;
                    // System.out.println(cur+"--"+count5);
                    if (count5 >= cur)
                    {
                        count5 -= cur;
                        if(ar[i]==5)
                        count5 += 1;
                        else
                            count10+=1;
                    }
                    else
                        {
                        f = -1;
                        break;
                    }
                }
            }
            else {
                for (int i = 0; i < n; i++) {
                    int cur = ar[i];
                    cur = cur - 5;
                    cur /= 5;
                    // System.out.println(cur+"--"+count5);
                    if (count5 >= cur) {
                        count5 -= cur;
                        count5 += 1;
                    } else {
                        f = -1;
                        break;
                    }
                }
            }
            if(f==0)
            {
                sb.append("YES\n");
            }
            else
            {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
}

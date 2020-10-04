import java.math.BigInteger;
import java.util.Scanner;

public class holi {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (t-- > 0) {
            int n=sc.nextInt();
            long sum=0;
            int ar[]=new int[n];

            for(int i=0;i<n;i++)
            {
                ar[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                sum+=ar[i];
            }
            long ans=0;
            for(int i=0;i<n;i++)
            {
                if(sum%ar[i]!=0)
                {
                    ans+=(sum/ar[i]) + (((sum%ar[i])/(double)ar[i])>=0.5?1:0);
                   // System.out.println((sum/ar[i])+"  "+((sum/ar[i]) + (sum%ar[i]/(double)ar[i])>=0.5?1:0));
                }
                else
                {
                    if(sum/ar[i]%2!=0)
                    {
                        ans+=(sum/ar[i])+1;
                    }
                    else
                    {
                        ans+=sum/ar[i];
                    }
                }
            }
            sb.append(ans+"\n");


        }
        System.out.println(sb.toString());
    }

}

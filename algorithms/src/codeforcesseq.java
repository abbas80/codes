import java.util.Arrays;
import java.util.Scanner;

public class codeforcesseq {
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            long k = sc.nextLong();


            StringBuilder sb=new StringBuilder();
            long ar[]=new long[10];
            char ch[]={'c','o','d','e','f','o','r','c','e','s'};
            Arrays.fill(ar,1);
            long p=1;
            int i=0;
            while(p<k)
            {
                p/=ar[i];
                ar[i]++;
                p*=ar[i];
                i++;
                if(i==10)
                    i=0;
            }

            for(i=0;i<10;i++)
            {
            while(ar[i]!=0)
            {
                sb.append(ch[i]);
                ar[i]--;
            }
            }
            System.out.println(sb.toString());

          }

}

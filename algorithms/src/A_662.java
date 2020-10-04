//
//package cf;
import java.io.*;
import java.util.*;

public class A_662 {
    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        StringBuilder sb=new StringBuilder();
        int n=sc.nextInt();
        int ar[]=new int[n];

        HashMap<Integer,Integer> h1=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            ar[i] = sc.nextInt();
            set.add(ar[i]);
            h1.put(ar[i],h1.getOrDefault(ar[i],0)+1);
        }
        Set<Integer> fr8=new HashSet<>();
        Set<Integer> fr=new HashSet<>();
        Set<Integer> tw=new HashSet<>();
        int four=0;
        int fv=0;
        int used4=0;
        int two=0;
        int tv=0;
        for(int j:set) {

            if (h1.get(j) >= 8) {
                fr8.add(j);
            }
            if (h1.get(j) >= 4&&h1.get(j)<=7) {
                fr.add(j);
                if(h1.get(j)-4>=2)
                    tw.add(j);

            }
            if (h1.get(j) >= 2 && h1.get(j)<4) {
                tw.add(j);
            }
        }
        int n1=sc.nextInt();
        int q[][]=new int[n1][2];
        for(int i=0;i<n1;i++) {

            String s[]=sc.nextLine().split(" ");
            q[i][0]=s[0].equals("+")?1:-1;
            q[i][1]=Integer.parseInt(s[1]);

        }
        for(int i=0;i<n1;i++)
        {
            if(q[i][0]<0)
            {
                int j=q[i][1];
                h1.put(q[i][1],h1.getOrDefault(q[i][1],0)-1);
                if(h1.get(j)>=6&&h1.get(j)<8)
                {
                    if(fr8.contains(j))
                    fr8.remove(j);

                    fr.add(j);
                    tw.add(j);
                }
                if(h1.get(j)>=4&&h1.get(j)<6)
                {
                    if(fr8.contains(j))
                        fr8.remove(j);
                    if(tw.contains(j))
                        tw.remove(j);
                    fr.add(j);
                }
                if(h1.get(j)<4)
                {
                    if(fr8.contains(j))
                        fr8.remove(j);
                    if(fr.contains(j))
                        fr.remove(j);
                tw.add(j);
                }
                if(h1.get(j)<2)
                {
                    if(fr8.contains(j))
                        fr8.remove(j);
                    if(fr.contains(j))
                        fr.remove(j);
                    if(tw.contains(j))
                        tw.remove(j);
                }
            }
            else
            {
                int j=q[i][1];
                h1.put(q[i][1],h1.getOrDefault(q[i][1],0)+1);

                if (h1.get(j) >= 8) {
                    if(fr.contains(j))
                        fr.remove(j);
                    if(tw.contains(j))
                        tw.remove(j);
                    fr8.add(j);
                }
                if (h1.get(j) >= 4&&h1.get(j)<=5) {
                    if(tw.contains(j))
                        tw.remove(j);
                    if(fr8.contains(j))
                        fr8.remove(j);
                    fr.add(j);
                }
                if (h1.get(j) >= 6&&h1.get(j)<=7) {

                    if(fr8.contains(j))
                        fr8.remove(j);
                    //fr.add(j);
                    tw.add(j);
                }
                if (h1.get(j) >= 2 && h1.get(j)<4) {
                    if(fr.contains(j))
                        fr.remove(j);
                    if(fr8.contains(j))
                        fr8.remove(j);
                    tw.add(j);

                }
            }
           //System.out.println(h1);
           //System.out.println(fr.size()+" "+tw.size()+"  "+fr8.size());
            if(tw.size()>=2&&fr.size()>=1||fr.size()>=2||fr8.size()>=1)//dg[4]==1&&dg[2]-1>=2||dg[4]>=2)
            {
                sb.append("YES\n");
            }
            else
                sb.append("NO\n");
        }
        System.out.println(sb.toString());
        // long k = sc.nextLong();
      /*  int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        int pos=-1;
        for(int i=31;i>=0;i--)
        {
            System.out.print(((n>>i)&1));
            if(((n>>i)&1)==1&&pos==-1)
            {

                pos=i+1;
             //   break;
            }

        }
        System.out.println();
        System.out.println(pos);
        if(pos%2==0)
        {
            n=toggle(n,pos/2);
            n=toggle(n,(pos/2)-1);
        }
        else
        {
            n=toggle(n,pos/2);
        }
        sb.append(n+"\n");*/

        //System.out.println(sb.toString());

        // StringBuilder sb=new StringBuilder();
        //   out.write(sb.toString());
        out.flush();
    }
    public static int toggle(int n,int k)
    {
        int t=((n>>k&1)<<k);
        System.out.println("t"+ t);
        if(t>0)
            n=n&~t;
        else
        {
            t=1<<k;
            n=n|t;
        }
        return n;
    }






    ///////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}

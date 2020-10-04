import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class graph {

    /*
     * Complete the componentsInGraph function below.
     */
    static int c=0;
    static int[] componentsInGraph(int n,int[][] gb) {
        /*
         * Write your code here.
         */
        HashMap<Integer,String> h1=new HashMap<>();
        Set<Integer> s1=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            s1.add(gb[i][0]);
            s1.add(gb[i][1]);

            if(h1.containsKey(gb[i][0]))
            {
                h1.put(gb[i][0],h1.get(gb[i][0])+" "+gb[i][1]);
            }
            else
            {
                List<Integer> l1=new ArrayList<>();
                h1.put(gb[i][0],""+gb[i][1]);
            }
        }
        HashMap<Integer,Boolean> vis=new HashMap<>();

        int sm=Integer.MAX_VALUE;
        int lr=Integer.MIN_VALUE;


        for(int i:s1)
        {
            vis.put(i,false);
        }
        for(int i:s1)
        {
            if(vis.get(i)==false)
            {
                dfs(i,vis,h1);
                sm=Math.min(sm,c);
                lr=Math.max(lr,c);
                c=0;
            }

        }
        int re[]=new int[2];
        re[0]=lr;
        re[1]=sm;
        return re;
    }
    public static void dfs(int v,HashMap<Integer,Boolean> vis,HashMap<Integer,String> h1)
    {
        c++;
        vis.put(v,true);
        String ar[]=h1.get(v).split(" ");
        List<Integer> l1=new ArrayList<>();
        for(String i:ar)
        {
            l1.add(Integer.parseInt(i));
        }
        for(int i=0;i<l1.size();i++)
        {
            if(vis.get(l1.get(i))==false)
            {
                dfs(l1.get(i),vis,h1);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(n,gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

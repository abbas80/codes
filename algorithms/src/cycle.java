import java.util.*;

public class cycle {public static void main (String[]args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    StringBuffer sb = new StringBuffer();
    while (t-- > 0) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ar[] = new int[n];

        for (int i = 0; i < n; i++)
            ar[i] = i;
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ar[a]=b;
        }

        StringBuilder inb = new StringBuilder();
        int c = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++)
        {
            int cur = ar[i];
            set.add(i);
            s.add(i);
            if (set.contains(cur)) {
                inb.append(set.size() + " ");
                //System.out.println(set);
                set.clear();
                c++;
            } else {
                set.add(cur);
                s.add(cur);
            }
        }

        sb.append(c+"\n"+inb.toString()+"\n");
        }
        System.out.println(sb.toString());
    }
}


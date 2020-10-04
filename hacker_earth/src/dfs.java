import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class dfs {
    public static void main(String[] args) {

    }

    public static void dfs(int cur, List<List<Integer>> ad, boolean vs[], Set<Integer> s,Set<Integer> qr) {
        vs[cur] = true;
        if(ad.get(cur).size()==0)
        {
            int c=0;
            for(int i:s)
            {
                if(qr.contains(i))
                    c++;
            }
            if(c==qr.size())
            {
                qr.clear();
                return;
            }
        }
        for (int i : ad.get(cur)) {
            s.add(i);
        }
            for (int i : ad.get(cur)) {
            dfs(i, ad, vs, s,qr);
            s.remove(i);
           }
            vs[cur] = false;
        }
    }



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hashing_rolling {
        ///https://codeforces.com/blog/entry/60445
    //refer this link
//https://leetcode.com/problems/distinct-echo-substrings/submissions/

// https://leetcode.com/problems/distinct-echo-substrings/discuss/477217/Java-Brute-force-and-Hash-Solution-Clean-code

    static long m = (long) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int n = text.length();
        long pow[] = new long[n + 1];
        long hash[] = new long[n + 1];
        pow[0] = 1;
        int p = 31;
        char ch[] = text.toCharArray();

        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] % m * p % m) % m;
        }

        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * p % m + (ch[i - 1]) % m) % m;
        }
        int c = 0;
        //System.out.println(Arrays.toString(pow));
        //System.out.println(Arrays.toString(hash));
        // function is hash(i+len) -hash(i)*pow(len);
        Set<Long> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j + (j - i) + 1 <= n; j++) {
                int len = j - i;
                //  System.out.println(i+" "+j);
                //System.out.println((j+1)+" "+(j+len+1));
                long h1 = gethash(pow, hash, i, j);
                long h2 = gethash(pow, hash, j + 1, j + len + 1);

                if (h1 == h2) {
                      System.out.println(i+" "+j+" "+text.substring(i-1,j)+" = "+text.substring(j,j+len+1));
                    //  c++;
                    set.add(h1);
                }
            }
        }
        System.out.println(set.size());
       // return set.size();
    }

    public static long gethash(long pow[], long hash[], int l, int r) {
        
        return (hash[r] - (hash[l - 1] * pow[r - l + 1]) % m + m) % m;
    }
}
// LCM of given range queries
// using Segment Tree

import java.util.Scanner;

class GFG
{

    static final int MAX = 1000;

    // allocate space for tree
    static int tree[] = new int[4 * MAX];

    // declaring the array globally
    static int arr[] = new int[MAX];

    // Function to return gcd of a and b
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    // utility function to find lcm
    static int lcm(int a, int b)
    {
        return gcd(a, b);
    }

    // Function to build the segment tree
    // Node starts beginning index
    // of current subtree. start and end
    // are indexes in arr[] which is global
    static void build(int node, int start, int end)
    {

        // If there is only one element
        // in current subarray
        if (start == end)
        {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        // build left and right segments
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        // build the parent
        int left_lcm = tree[2 * node];
        int right_lcm = tree[2 * node + 1];

        tree[node] = lcm(left_lcm, right_lcm);
    }

    // Function to make queries for
    // array range )l, r). Node is index
    // of root of current segment in segment
    // tree (Note that indexes in segment
    // tree begin with 1 for simplicity).
    // start and end are indexes of subarray
    // covered by root of current segment.
    static int query(int node, int start,
                     int end, int l, int r)
    {

        // Completely outside the segment, returning
        // 1 will not affect the lcm;
        if (end < l || start > r)
        {
            return -1;
        }

        // completely inside the segment
        if (l <= start && r >= end)
        {
            return tree[node];
        }

        // partially inside
        int mid = (start + end) / 2;
        int left_lcm = query(2 * node, start, mid, l, r);
        int right_lcm = query(2 * node + 1, mid + 1, end, l, r);
        if(left_lcm==-1)
            left_lcm=right_lcm;
        if(right_lcm==-1)
            right_lcm=left_lcm;

        return lcm(left_lcm, right_lcm);
    }

    // Driver code
    public static void main(String[] args)
    {

        //initialize the array
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        build(1, 0, n);

        // build the segment tree

        // Now we can answer each query efficiently
        // Print LCM of (2, 5)
        int m=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++)
        {
            int l=sc.nextInt();
            int r=sc.nextInt();
            l--;
            r--;
            int res=query(1, 0, n, l, r);
            sb.append(res+"\n");
        }
        //System.out.println(query(1, 0, 10, 2, 5));

        // Print LCM of (5, 10)
        //System.out.println(query(1, 0, 10, 5, 10));

        // Print LCM of (0, 10)
        //System.out.println(query(1, 0, 10, 0, 10));
        System.out.println(sb.toString());
    }
}

// This code is contributed by 29AjayKumar

import java.util.Scanner;

public class binary_Search {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int a[]={1,2,5,5,5,7};
        System.out.println(upper_binarysearch(a,4));
    }

    private static int upper_binarysearch(int[] a, int k) {
        int l=0,r=a.length -1;
        int ans=-1;
        while(l<=r)
        {
            int m=l+(r-l)/2 ;
             if(a[m]==k)
            {
                ans=m;
                r=m-1;//for lower bound(ielast occurance)
                l=m+1;//for upperbound
            }
             else if(a[m]<k)
             {
                 l=m+1;
             }
            else
            {
                r=m-1;
            }
        }
        if(ans==-1)
            return l;
            return ans;
    }
    private static int lower_binarysearch(int[] a, int k) {
        int l=0,r=a.length -1;
        int ans=-1;
        while(l<r)
        {
            int m=l+(r-l)/2 ;
            if(a[m]>=k)
            {
                r=m-1;
            }
            else
            {
                l=m+1;
            }
        }
        return r;
    }

}

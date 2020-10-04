import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class string_pair {
    /*
    0: 'zero', 1: 'one', 2: 'two', 3: 'three', 4: 'four', 5: 'five', 6: 'six', 7: 'seven', 8: 'eight', 9: 'nine', 10: 'ten', 11: 'eleven', 12: 'twelve', 13: 'thirteen', 14: 'fourteen', 15: 'fifteen', 16: 'sixteen', 17: 'seventeen', 18: 'eighteen', 19: 'nineteen', 20: 'twenty', 21: 'twentyone', 22: 'twentytwo', 23: 'twentythree', 24: 'twentyfour', 25: 'twentyfive', 26: 'twentysix', 27: 'twentyseven', 28: 'twentyeight', 29: 'twentynine', 30: 'thirty', 31: 'thirtyone', 32: 'thirtytwo', 33: 'thirtythree', 34: 'thirtyfour', 35: 'thirtyfive', 36: 'thirtysix', 37: 'thirtyseven', 38: 'thirtyeight', 39: 'thirtynine', 40: 'forty', 41: 'fortyone', 42: 'fortytwo', 43: 'fortythree', 44: 'fortyfour', 45: 'fortyfive', 46: 'fortysix', 47: 'fortyseven', 48: 'fortyeight', 49: 'fortynine', 50: 'fifty', 51: 'fiftyone', 52: 'fiftytwo', 53: 'fiftythree', 54: 'fiftyfour', 55: 'fiftyfive', 56: 'fiftysix', 57: 'fiftyseven', 58: 'fiftyeight', 59: 'fiftynine', 60: 'sixty', 61: 'sixtyone', 62: 'sixtytwo', 63: 'sixtythree', 64: 'sixtyfour', 65: 'sixtyfive', 66: 'sixtysix', 67: 'sixtyseven', 68: 'sixtyeight', 69: 'sixtynine', 70: 'seventy', 71: 'seventyone', 72: 'seventytwo', 73: 'seventythree', 74: 'seventyfour', 75: 'seventyfive', 76: 'seventysix', 77: 'seventyseven', 78: 'seventyeight', 79: 'seventynine', 80: 'eighty', 81: 'eightyone', 82: 'eightytwo', 83: 'eightythree', 84: 'eightyfour', 85: 'eightyfive', 86: 'eightysix', 87: 'eightyseven', 88: 'eightyeight', 89: 'eightynine', 90: 'ninety', 91: 'ninetyone', 92: 'ninetytwo', 93: 'ninetythree', 94: 'ninetyfour', 95: 'ninetyfive', 96: 'ninetysix', 97: 'ninetyseven', 98: 'ninetyeight', 99: 'ninetynine', 100: 'hundred'}
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ex="zero,  one,  two,  three,  four,  five,  six,  seven,  eight,  nine";
        //,  ten,  eleven,  twelve,  thirteen,  fourteen,  fifteen,  sixteen,  seventeen,  eighteen,
        // nineteen,  twenty,  twentyone,  twentytwo,  twentythree,  twentyfour,  twentyfive,  twentysix,
        // twentyseven,  twentyeight,  twentynine,  thirty,  thirtyone,  thirtytwo,  thirtythree,  thirtyfour,
        // thirtyfive,  thirtysix,  thirtyseven,  thirtyeight,  thirtynine,  forty,  fortyone,  fortytwo,  fortythree,
        // fortyfour,  fortyfive,  fortysix,  fortyseven,  fortyeight,  fortynine,  fifty,  fiftyone,  fiftytwo,  fiftythree,
        // fiftyfour,  fiftyfive,  fiftysix,  fiftyseven,  fiftyeight,  fiftynine,  sixty,  sixtyone,  sixtytwo,  sixtythree,
        // sixtyfour,  sixtyfive,  sixtysix,  sixtyseven,  sixtyeight,  sixtynine,  seventy,  seventyone,  seventytwo,  seventythree,
        // seventyfour,  seventyfive,  seventysix,  seventyseven,  seventyeight,  seventynine,  eighty,  eightyone,  eightytwo,  eightythree,
        // eightyfour,  eightyfive,  eightysix,  eightyseven,  eightyeight,  eightynine,  ninety,  ninetyone,  ninetytwo,  ninetythree,  ninetyfour,
        // ninetyfive,  ninetysix,  ninetyseven,  ninetyeight,  ninetynine,  hundred";
        String hs[]=ex.split(",");
        String ex1="2,2,1,2,2,2,1,2,2,2";
        //2,1,3,2,3,4,3,3,4,4,4,1,3,2,3,3,3,2,3,3,3,1,3
        // ,2,3,3,3,2,3,3,3,1,3,2,3,3,3,2,3,3,3,1,3,2,3
        // ,3,3,2,3,3,3,1,3,2,3,3,3,2,3,3,3,2,4,3,4,4,4,
        // 3,4,4,4,2,4,3,4,4,4,3,4,4,4,2,4,3,4,4,4,3,4,4,4,2";
        String v_c[]=ex1.split(",");
      //  System.out.println(v_c.length+"  "+hs.length);
        for(int i=0;i<hs.length;i++) {
            hs[i]=hs[i].trim();
        }
        int n=sc.nextInt();
        int ar[]=new int[n];
        long c=0;
        HashMap<Integer,Integer> fr=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
            char temp[]=(""+ar[i]).toCharArray();
            for(char te:temp)
            c+=Integer.parseInt(v_c[te-48]);
           // fr.put(ar[i],fr.getOrDefault(ar[i],0)+1);
        }
       // System.out.println(c);
        int tc=0;
         // System.out.println(tc);
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(ar[i]+ar[j]==c)
                    tc++;
            }
        }
        if(tc<=100)
            System.out.print(hs[tc].toLowerCase().trim());
        else
            System.out.print( "greater 100");
        //  System.out.println(hs.length+"  "+v_c.length);
      /* HashMap<Integer,String> h1=new HashMap<>();
        for(int i=0;i<hs.length;i++)
       {
           hs[i]=hs[i].trim();
            h1.put(i,hs[i]);
       }
        HashSet<Character> vov=new HashSet<>();
        vov.add('u');
        vov.add('o');vov.add('i');vov.add('e');vov.add('a');
        StringBuilder sb=new StringBuilder();
        for(String i:hs)
        {
            char t[]=i.toCharArray();
            int c=0;
            for(char cur:t)
            {
                if(vov.contains(cur))
                {
                    c++;
                }
            }
            sb.append(c+",");
        }*/
        //  System.out.println(sb.toString());
    }

}

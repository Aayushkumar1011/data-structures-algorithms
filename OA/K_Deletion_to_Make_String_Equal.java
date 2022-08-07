import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int k = sc.nextInt();
        int n = s.length();
        int m = t.length();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        boolean res = solve(s1, t1, n, m, k, visited);

        if(res == true){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
        
    }
    
    
    public static boolean solve(char[] s, char[] t, int n, int m, int k, int[] visited){
        // System.out.println("S: " + Arrays.toString(s));
        if(Arrays.equals(s, t) == true)
            return true;
        if(k == 0)
            return false;
        boolean ans = false;
        
        for(int i = 0; i < n; i++){
            if(visited[i] == -1){
                char ch = s[i];
                // s[i] = (char)((s[i]+(char)(k%26))%26);
//                 s[i] = (char)(((s[i] - 'a') + k%26)%25) + 65; 
                s[i] = char(((s[i] - 'a' + k % 26)) % 25) + 'a';
                
                visited[i] = 1;
                ans = ans || solve(s, t, n, m, k-1, visited);
                s[i] = ch;
                visited[i] = -1;
            }
        }
        return ans;
    }
    
}

import java.util.*;

public class 3_MinWindowSubstring  {
    public String findMinWindowString(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int required = map.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        
        int[] ans = {-1, 0, 0}; // length, left, right
        
        while(r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            if(map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }
            
            while(l <= r && formed == required) {
                c = s.charAt(l);
                
                if(ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                windowCounts.put(c, windowCounts.get(c) - 1);
                if(map.containsKey(c) && windowCounts.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                
                l++;
            }
            
            r++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.findMinWindowString(s, t)); // Output: "BANC"
    }
}

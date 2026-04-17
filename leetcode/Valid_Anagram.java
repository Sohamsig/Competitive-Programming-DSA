import java.util.Arrays;

class Solution {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();   

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        if (isAnagram(s, t) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

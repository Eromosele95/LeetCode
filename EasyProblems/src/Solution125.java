class Solution125 {

    // Checking if string "s" is a valid palindrome,
    // Sring may contain letters, punctuation, etc
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1){
            return true;
        }
        String stripped = s.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().replace(" ", "");
        int i = 0;
        int j = stripped.length()-1;
        while(j > i){
            if(stripped.charAt(i) != stripped.charAt(j)){
                break;
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}
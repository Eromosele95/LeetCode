object Solution {

    // Given a string, reverse the string word by word 
    // "the sky is blue" -> "blue is sky the"
    // no trailing spaces in the reversed word 
    def reverseWords(s: String): String = {
        if(s.length ==  0) s
        else {
          val ans =  s.trim.replaceAll(" +", " ").split(" ").reverse
            ans.mkString(" ")
        }
        
    }
}
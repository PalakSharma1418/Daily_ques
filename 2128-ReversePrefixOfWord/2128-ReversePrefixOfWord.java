// Last updated: 8/6/2025, 4:43:59 PM
class Solution {
    public String reversePrefix(String word, char ch) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == ch) {
                int j = 0;
                while (j <= i) {
                    char temp = wordArr[j];
                    wordArr[j] = wordArr[i];
                    wordArr[i] = temp;
                    j++;
                    i--;
                }
                break;
            }
        }
        return new String(wordArr);
    }
}
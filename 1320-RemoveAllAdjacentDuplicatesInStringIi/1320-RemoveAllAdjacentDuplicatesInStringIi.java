// Last updated: 8/6/2025, 4:45:47 PM
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!charStack.isEmpty() && charStack.peek()==ch){
                countStack.push(countStack.pop() + 1);//yha hum count kar rhe same character ko jo dusri stack mai hai
            }
            else{
                // khali ho pheli baar char aya hai ye to
                  charStack.push(ch);
                countStack.push(1);
            }
            // jab bo k time aa gya now pop ek baar isliye kyuki hum count bada rhe uski na ki baar humne push kiya
             if (countStack.peek() == k) {
                charStack.pop();
                countStack.pop();
            }
        }
            StringBuilder sb = new StringBuilder();
            while (!charStack.isEmpty()) {
                char ch = charStack.pop();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                }
            }

        return sb.reverse().toString();
    }
}
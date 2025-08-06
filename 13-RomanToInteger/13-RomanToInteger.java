// Last updated: 8/6/2025, 4:51:38 PM
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;
        
        // Iterate through the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int currValue = getRomanValue(c);
            
            // If current value is greater than or equal to previous, add it
            if (currValue >= prevValue) {
                result += currValue;
            } else {
                // If current value is less than previous, subtract it
                result -= currValue;
            }
            prevValue = currValue;
        }
        
        return result;
    }
    
    private int getRomanValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
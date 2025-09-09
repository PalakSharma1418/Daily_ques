// Last updated: 9/9/2025, 7:50:01 PM
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // start with 1 slot for the root

        for (String node : nodes) {
            // consume one slot for the current node
            slots--;

            // if slots go negative, it's invalid
            if (slots < 0) return false;

            // if it's a number, it adds 2 slots (for its children)
            if (!node.equals("#")) {
                slots += 2;
            }
        }

        // valid if all slots are used up
        return slots == 0;
    }
}

package LinkedList;

public class DiamondBox {
    private String config;

    public DiamondBox(String c) {
        this.config = c;
    }

    //Time complexity O(N)
// isValid complexity = O(N)
    public boolean isValid() {
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        int outerBoxCloseCount = 0;

        for (int i = 0; i < config.length(); i++) {
            char letter = config.charAt(i);

            if (letter == '[') {
                stack.push(letter);
            } else if (letter == ']') {
                if (stack.isEmpty()) return false; // unmatched close
                stack.pop();

                if (stack.isEmpty()) {
                    outerBoxCloseCount++;
                    if (outerBoxCloseCount > 1) {
                        // More than one top-level box
                        return false;
                    }
                }
            } else if (letter == '*') {
                if (stack.isEmpty()) return false; // diamond outside any box
            } else {
                return false; // invalid character
            }
        }

        return stack.isEmpty() && outerBoxCloseCount == 1;
    }



    //Complexity O(N)
    private int deepestLevel(){
        LinkedListStack<Character> boxStack = new LinkedListStack<Character>();
        int maxLevel =0 ;
        for (char ch : config.toCharArray()){
            if (ch == '['){
                boxStack.push(ch);
                maxLevel = Math.max(maxLevel, boxStack.size());
                continue;
            }
            if (ch == ']'){
                boxStack.pop();
            }
        }
        return maxLevel;
    }

    public int maxDiamonds() {
        int maxValue = 0;
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();

        for (int i = 0; i < config.length(); i++) {
            // If it's an opening bracket, push a new box (0 diamonds)
            if (config.charAt(i) == '[') {
                stack.push(0);
                continue;
            }
            // If it's a closing bracket, pop the box and compare its diamond count
            if (config.charAt(i) == ']') {
                stack.pop();
                continue;
            }

            //Find more diamond
            int current = stack.peek();
            stack.pop();
            stack.push(current + 1);
            maxValue = Math.max(maxValue, current +1 );

        }

        return maxValue;
    }


    public static void main(String[] args) {
        String[] testCases = {"[[][]]", "[**[****]*]", "[[[][***[****]**]]]", "[][]",
                "[]*", "*[]", "[**[**]*]","[[[*]**]*]"};
        for (int t = 0; t < testCases.length; t++) {
            System.out.println(testCases[t]);
            DiamondBox box = new DiamondBox(testCases[t]);
            boolean valid = box.isValid();
            if (valid) {
                System.out.println("Valid");
                System.out.println(box.maxDiamonds());
//                System.out.println(box.deepestLevel());
            } else {
                System.out.println("Invalid");
            }
            System.out.println();
        }
    }
}


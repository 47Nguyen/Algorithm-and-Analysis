public class P1Stack {
    int[] arrayInt;

    public P1Stack(int[] arrayInt){
        this.arrayInt = arrayInt;

    }

    public static void main(String[] args) {
        int[] array = {29,7,99,20,5,18,6,99,60};
        P1Stack p1 = new P1Stack(array);
        p1.pushStack();
    }
    void pushStack(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        int count = 0;
        for (int j : arrayInt) {
            if (j == 99) {
                count++;
                if(count ==2){
                    break;
                }
                continue;
            }
            if (count == 1) {
                stack.push(j);
            }
        }
        printStack(stack);
    }

    void printStack(ArrayStack<Integer> stack){
        for (int i = stack.size(); i >0; i--){
            System.out.print(stack.pop() + " ");
        }
    }
}

package nowcoder.arrayqueuestack;

import java.util.Stack;

public class GetMinStackSolution {
    public static class GetMinStack{
        Stack<Integer> stackData;
        Stack<Integer>stackMin;
        public GetMinStack(){
            stackData=new Stack<>();
            stackMin=new Stack<>();
        }

        public void push(int obj){
            stackData.push(obj);
            if(stackMin.isEmpty()){
                stackMin.push(obj);
            }else if(obj<=getmin()){
                stackMin.push(obj);
            }
        }
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public Integer pop(){
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

    }

    public static void main(String[]args){
        GetMinStack stack=new GetMinStack();
        stack.push(3);
        System.out.println(stack.getmin());
        stack.push(4);
        System.out.println(stack.getmin());
        stack.push(1);
        System.out.println(stack.getmin());
        System.out.println(stack.pop());
        System.out.println(stack.getmin());
    }
}

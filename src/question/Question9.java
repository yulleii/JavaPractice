package question;

import java.util.Stack;

/*
    用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class Question9 {
    public static void main(String[] args) {
        Question9 question9=new Question9();
        for(int i=0;i<10;i++)
            question9.push(i);
        for(int i=0;i<10;i++){
            System.out.print(question9.pop());
        }
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public int pop() {
        if(stack1.empty() && stack2.empty())
            throw new RuntimeException("Queue is empty!");
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

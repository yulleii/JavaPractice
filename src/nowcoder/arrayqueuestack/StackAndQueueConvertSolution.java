package nowcoder.arrayqueuestack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvertSolution {
    public static class TwoStacksQueue{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public TwoStacksQueue(){
            stack1=new Stack<>();
            stack2=new Stack<>();
        }
        public void add(int obj){
            stack1.push(obj);
        }

        public Integer poll(){
            if(stack1.isEmpty() && stack1.isEmpty())
                throw new RuntimeException("Queue is empty!");
            else if(stack2.isEmpty()){
                while(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public int peek(){
            if(stack1.isEmpty() && stack1.isEmpty())
                throw new RuntimeException("Queue is empty!");
            else if(stack2.isEmpty()){
                while(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.peek();
        }


    }

    public static class TwoQueuesStack{
        private Queue<Integer> queue;
        private Queue<Integer>help;

        public TwoQueuesStack(){
            queue=new LinkedList<Integer>();
            help=new LinkedList<Integer>();
        }

        public void push(int obj){
            queue.add(obj);
        }

        public Integer pop(){
            if(queue.isEmpty())
                throw new RuntimeException("Stack is empty!");
            while(queue.size()!=1)
                help.add(queue.poll());
            int tmp=queue.poll();
            swap();
            return tmp;
        }

        public Integer peek(){
            if(queue.isEmpty())
                throw new RuntimeException("Stack is empty!");
            while(queue.size()!=1)
                help.add(queue.poll());
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }
        public void swap(){
            Queue<Integer>tmpQ=queue;
            queue=help;
            help=tmpQ;
        }
    }
}

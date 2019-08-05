package nowcoder.arrayqueuestack;
/*
用数组结构实现大小固定的队列和栈
 */
public class ArrayStackSolution {
    //Stack
    public static class ArrayStack{
        private Integer[]arr;
        private Integer size;
        public ArrayStack(int size){
            if(size<0)
                throw new IllegalArgumentException("数组长度不能小于0");
            arr=new Integer[size];
            this.size=0;
        }

        public void push(int obj){
            if(size==arr.length)
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            arr[size]=obj;
            size++;
        }

        public Integer pop(){
            if(size==0)
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            return arr[--size];
        }

        public Integer peek(){
            if(size==0)
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            return arr[size-1];
        }
    }
    //Queue
    public static class ArrayQueue{
        private Integer[]arr;
        private int start;
        private int end;
        private int size;
        public ArrayQueue(int initSize){
            if(initSize<0)
                throw new IllegalArgumentException("the size is less than 0");
            arr=new Integer[initSize];
            size=0;
            start=0;
            end=0;
        }

        public void push(int obj){
            if(size==arr.length)
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            size++;
            arr[end]=obj;
            end=end==arr.length-1?0:end+1;
        }

        public Integer poll(){
            if(size==0)
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            size--;
            int tmp=arr[start];
            start=start==arr.length-1?0:start+1;
            return tmp;
        }

        public Integer peek(){
            if(size==0)
                return null;
            return arr[start];
        }
    }
}

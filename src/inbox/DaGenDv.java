package inbox;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DaGenDv {
    static int count=0;
    static PriorityQueue<Integer>maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    static PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    public static void main(String[] args) {
        Insert(1);
        Insert(3);
        Insert(5);
        Insert(2);
    }
    public static void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 判断偶数的高效写法
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }
}

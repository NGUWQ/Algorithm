package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/23
 * \* Time: 22:53
 */
/*
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * */
public class Solution63 {
    ArrayList<Integer> al = new ArrayList<Integer>();

    public void Insert(Integer num) {
        al.add(num);

    }

    public Double GetMedian() {
        Collections.sort(al);
        int size = al.size() - 1;
        if (size % 2 == 0)
            return Double.valueOf(al.get(size / 2));
        else
            return Double.valueOf(al.get(size / 2) + al.get((size / 2) + 1)) / 2;

    }


    private PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private int count = 0;

    public void Insert2(Integer num) {
        if (count % 2 == 0) {
            minheap.offer(num);
            maxheap.offer(minheap.poll());
        } else {
            maxheap.offer(num);
            minheap.offer(maxheap.poll());
        }
        count++;

    }

    public Double GetMedian2() {
        if (count % 2 == 0) return new Double(minheap.peek() + maxheap.peek()) / 2.0;
        else return new Double(maxheap.peek());
    }

    public void Insert3(Integer num) {
        if (maxheap.isEmpty() || num <= maxheap.peek()) maxheap.offer(num);
        else minheap.offer(num);
        if (maxheap.size() == minheap.size() + 2) {
            minheap.offer(maxheap.peek());
            maxheap.poll();
        }
        if (maxheap.size()+1==minheap.size()){
           maxheap.offer(minheap.peek());
            minheap.poll();
        }

    }

    public Double GetMedian3() {
        return minheap.size()==maxheap.size()?(minheap.peek()+maxheap.peek())/2.0:new Double(maxheap.peek());
    }

    public static void main(String[] args) {
        Solution63 s = new Solution63();
        s.Insert3(1);
        s.Insert3(2);
        s.Insert3(3);
        s.Insert3(4);
        s.Insert3(5);
        s.Insert3(6);

        System.out.println(s.GetMedian3());

    }

}

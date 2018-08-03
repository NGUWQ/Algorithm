package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/13
 * \* Time: 22:21
 */
//二分查找(递归)分治算法的一种
class BinarySearch {
    private int[] arr;
    private int items;

    public BinarySearch(int max) {
        arr = new int[max];
        items = 0;
    }

    public void insert(int value) {
        int j;
        for (j = 0; j < items; j++) {
            if (arr[j] > value)
                break;
        }
        for (int k = items; k > j; k--) {
            arr[k] = arr[k - 1];
        }
        arr[j] = value;
        items++;
    }

    public int recFind(int value, int l, int r) {
        int half;
        half = (l + r) / 2;
        if (arr[half] == value)
            return half;
        else if (l > r) {
            return items;
        } else {
            if (arr[half] > value) {
                return recFind(value, l, half - 1);
            } else {
                return recFind(value, half + 1, r);
            }
        }
    }

    public void find(int value) {
        int reuslt = recFind(value, 0, items - 1);
        if (reuslt == getItems())
            System.out.println("找不到元素" + value + "!!! 请添加吧！！！");
        else
            System.out.println("在数组下标" + reuslt + "处找到此元素");


    }

    public void delete(int value) {
        int result = recFind(value, 0, items - 1);
        for (int i = result; i < items; i++)
            arr[i] = arr[i + 1];
        items--;
    }

    public void display() {
        System.out.print("数组arr为: ");
        for (int i = 0; i < items; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public int getItems() {
        return items;
    }
}

public class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;

        BinarySearch bin = new BinarySearch(maxSize);
        bin.insert(9);
        bin.insert(3);
        bin.insert(1);
        bin.insert(8);
        bin.insert(10);
        bin.insert(5);
        bin.insert(2);
        bin.insert(6);
        bin.insert(4);
        bin.display();
        //bin.find(11);
        bin.delete(9);
        bin.display();
    }  // end main()
}

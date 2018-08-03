package shujujiegou.day9;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/25
 * \* Time: 19:25
 */
class Hashtable {

    private Data[] array;
    private int size;
    private Data noValue;
    private int count;// 计算数组中的真实项数

    public int getCount() {
        return count;
    }

    public void setCount() {
        count = 0;
    }

    public Hashtable(int size) {
        this.size = size;
        array = new Data[size];

        noValue = new Data(-1);
    }

    public Data[] rehash(Data[] array) {
        Data[] arrays = new Data[2 * array.length+1];
        size=arrays.length;//获取新数组的长度
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getValue() != -1)
                arrays[i] = array[i];
        }
        return arrays;
    }

    public void displayTable() {
        System.out.print("table：");
        for (int j = 0; j < size; j++) {
            if (j % 10 == 0)
                System.out.println();
            if (array[j] != null && array[j].getValue() != -1) {
                System.out.print(array[j].getValue() + " ");
            } else
                System.out.print("**" + " ");
        }
        System.out.println();
    }

    //折叠分组（哈希函数）
    public int hashFuc4(int size, int value) {
        int n = 0;
        while (value >= size) {
            n += value % size;
            value = value / size;
        }
        n += value;
        return n % size;
    }

    public int hashFunc1(int value) {
        return value % size;
    }

    //再哈希法
    public int hashFunc3(int value) {
        return 5 - value % 5;
    }

    //线性探测
    public void insert(Data data) {
        ++count;
        double rush = (double) count / size;
        if (rush >= 0.5)
            array = rehash(array);
        int value = data.getValue();
        //int hashindex = hashFunc1(key);
        int hashindex = hashFuc4(size, value);//折叠分组

        while (array[hashindex] != null && array[hashindex].getValue() != -1) {
            ++hashindex;
            hashindex = hashindex % size;
        }
        array[hashindex] = data;

    }

    //编程作业11.1 二次探测
    public void insert2(Data data) {
        int key = data.getValue();
        int hashindex = hashFunc1(key);
        int step = 1;

        while (array[hashindex] != null && array[hashindex].getValue() != -1) {
            hashindex += step * step;
            ++step;
            hashindex = hashindex % size;
        }
        array[hashindex] = data;
    }

    //再哈希法
    public void insert3(Data data) {
        int key = data.getValue();
        int hashindex = hashFunc1(key);
        int step = hashFunc3(key);

        while (array[hashindex] != null && array[hashindex].getValue() != -1) {
            hashindex += step;
            hashindex = hashindex % size;
        }
        array[hashindex] = data;
    }

    public Data delete(int value) {
        //int hashindex = hashFunc1(value);
        int hashindex = hashFuc4(size, value);//折叠返祖

        while (array[hashindex] != null) {
            if (array[hashindex].getValue() == value) {
                Data temp = array[hashindex];
                array[hashindex] = noValue;
                --count;
                return temp;
            } else {
                ++hashindex;
                hashindex %= size;
            }
        }
        return null;
    }

    public Data delete3(int value) {
        int hashindex = hashFunc1(value);
        int step = hashFunc3(value);

        while (array[hashindex] != null) {
            if (array[hashindex].getValue() == value) {
                Data temp = array[hashindex];
                array[hashindex] = noValue;
                return temp;
            } else {
                hashindex += step;
                hashindex = hashindex % size;
            }
        }
        return null;
    }

    public Data find(int value) {
        //int hashindex = hashFunc1(value);
        int hashindex = hashFuc4(size, value);//折叠返祖
        while (array[hashindex] != null) {
            if (array[hashindex].getValue() == value)
                return array[hashindex];
            else {
                ++hashindex;
                hashindex %= size;
            }
        }
        return null;
    }

    public Data find3(int value) {
        int hashindex = hashFunc1(value);
        int step = hashFunc3(value);
        while (array[hashindex] != null) {
            if (array[hashindex].getValue() == value)
                return array[hashindex];
            else {
                hashindex += step;
                hashindex = hashindex % size;
            }
        }
        return null;
    }
}

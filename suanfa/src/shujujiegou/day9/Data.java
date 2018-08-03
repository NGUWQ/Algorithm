package shujujiegou.day9;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/23
 * \* Time: 18:38
 */
//哈希表的简单实现和解决哈希表的冲突,开放地址法,其中方法1是只用了线性探测,这样很容易造成聚集,效率很低.
    //方法二是使用了再哈希避免了数据的聚集.
class Data {

    private int value;

    public Data(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

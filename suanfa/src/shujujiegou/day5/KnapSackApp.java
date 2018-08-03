package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/18
 * \* Time: 10:53
 */
//背包问题(递归)
public class KnapSackApp {
    private int[] weights;//可供选择的重量
    private boolean[] selects;//记录是否被选择

    public KnapSackApp(int[] weights) {
        this.weights = weights;
        selects = new boolean[weights.length];
    }

    //total:目标值,每次递归，直到total=0为止.
    //index:角标值,用以访问数组的位置
    public void knapsack(int total, int index) {
        if (total < 0 || total > 0 && index >= weights.length)//不满足基值
            return;
        if (total == 0)//满足基值
        {
            System.out.print("满足背包的值为：");
            for (int i = 0; i < index; i++) {
                if (selects[i] == true)
                    System.out.print(weights[i] + " ");
            }
            System.out.println();
            return;
        }

        selects[index] = true;

        knapsack(total - weights[index], index + 1);

        selects[index] = false;

        knapsack(total, index + 1);
    }


    public static void main(String[] args) {

        KnapSackApp k = new KnapSackApp(new int[]{11, 8, 7, 6, 5});
        k.knapsack(10, 0);

    }


}


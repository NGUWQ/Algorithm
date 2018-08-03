package suanfadaolun;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/25
 * \* Time: 17:08
 */
//m阶矩阵的相乘
public class Martrix {

    //暴力解法,时间复杂度n^3
    int[][] method1(int[][] a) {
        int m=a.length;
        int[][] c = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = 0;
                for (int k = 0; k < m; k++) {
                    c[i][j]+= a[i][k]*a[k][j];
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {

        int[][] a = {{1, 1}, {1, 0}};
        int[][] c = new Martrix().method1(a);
        System.out.println(c[0][0]);

    }
}

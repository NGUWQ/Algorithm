package shujujiegou.day5;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/5/19
 * \* Time: 0:58
 */
//排列(背包)组合问题(递归) 从5个人中选3个人出来
public class ZuHeApp {
    private int[] peoples;//可供选择的人员
    private boolean[] selects;//是否被选择

    public ZuHeApp(int[] peoples){
        this.peoples=peoples;
        selects=new boolean[peoples.length];
    }

    public void zuhe(int target){
        zuhe(peoples.length,target);
    }

    //people:总共有多少人供选择
    //target:需要选择多少人
    public void zuhe(int people,int target){
        if (target==0){
            for (int i=0;i<selects.length;i++)
            {
                if (selects[i]==true)
                    System.out.print(peoples[i]+" ");
            }
            System.out.println();
            return;
        }

        if (people<target)
            return;

        selects[peoples.length-people]=true;
        zuhe(people-1,target-1);
        selects[peoples.length-people]=false;
        zuhe(people-1,target);
    }

    public static void main(String[] args) {

        ZuHeApp z=new ZuHeApp(new int[]{5,4,3,2,1,6});
        z.zuhe(3);
    }
}

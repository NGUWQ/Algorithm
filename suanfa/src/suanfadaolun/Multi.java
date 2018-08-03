package suanfadaolun;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: TTT
 * \* Date: 2018/6/25
 * \* Time: 18:02
 */
//乘方(递归)
public class Multi {

    int method(int numbers,int exe){
        if (exe==1)
            return numbers;
        else if (exe%2==0){
            exe/=2;
            int result=method(numbers,exe);
            return result*result;
        }
        else {
            exe/=2;
            int result=method(numbers,exe);
            return result*result*numbers;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Multi().method(2,10));
    }
}

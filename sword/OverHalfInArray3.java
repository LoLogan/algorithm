/**
 * 数组中出现次数超过一半的数字
 *  思路：
 *      数组中一个数字出现的次数比其他所有数字出现的次数的和还要多。
 *      在遍历数组的时候保存两个值，一个是数组中的一个数字，一个是该数字出现的次数
 *      当我们遍历下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加一
 *      如果和我们之间保存的数字不同，则次数减一。当次数为0时，需要保存下一个数字，并将次数设置为1
 */
public class OverHalfInArray3 {

    public int moreThanHalfNum(int[] arr){
        //参数校验
        if(arr == null || arr.length == 0)
            throw new RuntimeException("输入参数有误！");

        int result = arr[0];
        int times = 1;
        for(int i = 1; i < arr.length; i++){
            if(times == 0){
                result = arr[i];
                times = 1;
            }
            else if(arr[i] == result)
                times++;
            else
                times--;
        }

        //判断是否数组中的数字有超过半数的
        times = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == result){
                times++;
            }
        }
        if(times <= arr.length / 2){
            throw new RuntimeException("出现次数没有超过一半的数字");
        }
        return result;
    }

    public static void main(String[] args) {
        OverHalfInArray3 test = new OverHalfInArray3();
        int[] arr = {1,2,1,2};
        System.out.println(test.moreThanHalfNum(arr));
    }

}
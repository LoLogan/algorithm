import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class OddEventArray {

    public void reorderOddEvent(int[] array){
        if(array == null || array.length == 0){
            return ;
        }

        int len = array.length;
        int low = 0;
        int high = len - 1;
        while(low <= high){
            while(!isEvent(array[low]) && low <= len - 1){
                low++;
            }
            while(isEvent(array[high]) && high >= 0){
                high--;
            }
            if(low <= high){
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
    }

    //判断是否是偶数,true:偶数;false:奇数
    public boolean isEvent(int num){
        return (num & 1) == 0;
    }

    public static void main(String[] args) {
        OddEventArray test = new OddEventArray();
        int[] array = {2,1};
        System.out.println(Arrays.toString(array));
        test.reorderOddEvent(array);
        System.out.println(Arrays.toString(array));
    }

//奇数偶数内部的顺序不变
    public void reOrderArray(int [] array) {
        if(array==null||array.length==0) return;
        int i = 0,j = 0,temp=0,k=0;
        while(i<array.length){
            while(i<array.length && array[i]%2!=0)
                i++;  //第一个偶数下标
            j = i+1;

            while(j<array.length && array[j]%2==0){
                j++;    //偶数后面的第一个奇数下标
            }
            if(j==array.length) return;
            if(j<array.length){
                temp = array[j];
                for(k = j-1; k>=i; k--){
                    array[k+1] = array[k];
                }
                array[i] = temp;
                i++;
            }
            //else break;
        }
    }

}
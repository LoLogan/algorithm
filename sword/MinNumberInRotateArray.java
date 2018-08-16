/**
 * 旋转数组中的最小值
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *
 */
public class MinNumberInRotateArray {

    public static Integer min(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        int low = 0;
        int high = array.length - 1;
        int mid = low; // 这样赋值的原因是：如果将0个元素搬到数组的后面

        /**
         * 如果能进入此处循环说明当前还是旋转数组
         */
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = (low + high) / 2;
            // 如果low、high、mid三者指向的数字相等，只能顺序查找
            // 因为我们无法判断中间数是属于第一个递增子数组还是属于第二个递增子数组
            if (array[low] == array[mid] && array[high] == array[mid]) {
                return minInOrder(array);
            }

            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }

    public static int minInOrder(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        Integer result = min(array);
        System.out.println(result);
    }
}
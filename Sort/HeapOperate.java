public class HeapOperate {
    /*
     * 建立堆时只需要保证根结点小于两个子结点或者大于两个子结点，对两个子结点大小没有要求
     */

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        swap(a[0],a[1]);


        //在堆排序之前，打印初始数组
        System.out.println(a);
        //进行堆排序
        heapSort(a);
        //进行堆排序之后
        System.out.println(a);
    }


    public static void heapSort(int[] a) {
        //建立大根堆
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            swap(a[0], a[i]);
            maxHeap(a, i, 0);
        }
    }

    private static void buildMaxHeap(int[] a) {
        int half = a.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }
    }

    private static void maxHeap(int[] a, int heapSize, int index) {
        //找出index位置处左右孩子的位置left和right
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && a[left] > a[index]) {
            largest = left;
        }

        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }

        if (index != largest) {
            //交换两个数据
            swap(a[index], a[largest]);
            maxHeap(a, heapSize, largest);
        }
    }

    private static void swap(int a,int b) {

    }


}

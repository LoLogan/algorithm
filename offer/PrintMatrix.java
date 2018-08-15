/**
 * 顺时针打印数组
 */
public class PrintMatrix {

    /**
     * 顺时针打印数组
     *
     * @param numbers
     *            二维数组
     * @param rows
     *            行数
     * @param columns
     *            列数
     */
    public void printMatrixClockwisely(int[][] numbers, int rows, int columns) {
        if (numbers == null || rows <= 0 || columns <= 0) {
            return;
        }
        int start = 0;
        while (start * 2 < columns && start * 2 < rows) {
            printMatrixInCircle(numbers, rows, columns, start);
            start++;
        }
    }

    public void printMatrixInCircle(int[][] numbers, int rows, int columns,int start) {
        //终止列号
        int endX = columns - 1 - start;
        //终止行号
        int endY = rows - 1 - start;
        //从左至右打印一行
        for(int i = start; i <= endX; i++){
            System.out.print(numbers[start][i]+"  ");
        }
        //从上到下打印一列
        if(endY > start){
            for(int i = start+1; i<= endY; i++){
                System.out.print(numbers[i][endX] + "  ");
            }
        }
        //从右至左打印一行
        if(endY > start && endX > start){
            for(int i  = endX-1 ; i>= start; i--){
                System.out.print(numbers[endY][i] + "  ");
            }
        }
        //从下到上打印一列
        if(endY - 1 > start && endX > start){
            for(int i = endY-1; i >= start+1 ; i--){
                System.out.print(numbers[i][start] + "  ");
            }
        }
    }
}
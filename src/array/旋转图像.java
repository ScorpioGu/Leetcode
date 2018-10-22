package array;

/**
 * @Desc https://leetcode.com/problems/rotate-image/description/
 * 用二维矩阵代表图像，将所有元素顺时针旋转90度
 * 空间复杂度要求in-place，不能新建矩阵。
 *
Given input matrix =
[
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
[15,13, 2, 5],
[14, 3, 4, 1],
[12, 6, 8, 9],
[16, 7,10,11]
]
 *
 * @Author gcc
 * @Date 18-10-22 上午11:27
 **/
public class 旋转图像 {
    public void rotate(int[][] matrix) {

        int length = matrix.length;
        //分圈旋转，不论这个矩阵的长度宽度为奇为偶，都是旋转length/2个圈
        for (int i = 0; i < length/2; i++) {
            //从最外层圈开始旋转
            for (int j = i; j < length-i-1; j++) {
                //每一层要经过3次元素的交换
                int x = i, y = j;
                for (int k = 0; k<3; k++) {
                    int tempV = matrix[x][y];
                    matrix[x][y] = matrix[length - y - 1][x];
                    matrix[length - y - 1][x] = tempV;
                    int tempX = x;
                    x = length - y - 1;
                    y = tempX;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5,1,9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        new 旋转图像().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("line");
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }
}

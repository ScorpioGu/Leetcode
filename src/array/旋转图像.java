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


    public  void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public  void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
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

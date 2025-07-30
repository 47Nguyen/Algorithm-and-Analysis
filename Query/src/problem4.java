public class problem4 {
    public static int findAreaMatrix(int[][] matrix, int topRow,int leftCol, int bottomRow, int rightCol){
        int area = 0;
        for (int i = topRow; i <= bottomRow;i++){
            for (int j = leftCol; j <= rightCol; j++){
                area += matrix[i][j];
            }
        }
        return area;

    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {8, 6, 9, 1, 3},
                {8, 3, 1, 4, 3},
                {4, 8, 2, 9, 6}
        };
        System.out.println(findAreaMatrix(matrix, 0,0,3,4));

    }
}

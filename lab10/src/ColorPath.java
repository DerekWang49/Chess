import java.util.*;
public class ColorPath {

//    private int[][] arr;
//    private int row;
//    private int col;
//    public void BFS(int[][] arr, int row, int col) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] {row, col});
//        while (queue.remove() != null) {
//            int [] temp = queue.remove();
//            if (temp[0] - 1 >= 0) {
//
//            }
//        }
//     }

    public static int[][] colorPath(int[][] image, int sourceRow, int sourceCol, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sourceRow, sourceCol});
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            if (image[temp[0]][temp[1]] != newColor) {
                if (temp[1] - 1 >= 0) {
                    if (image[temp[0]][temp[1] - 1] == image[temp[0]][temp[1]]) {
                        // Left
                        // System.out.println("Case 1");
                        queue.add(new int[] {temp[0], temp[1] - 1});
                    }

                } if (temp[1] + 1 < image[0].length) {
                    if (image[temp[0]][temp[1] + 1] == image[temp[0]][temp[1]]) {
                        // Right
                        // System.out.println("Case 2");
                        queue.add(new int[] {temp[0], temp[1] + 1});
                    }

                } if (temp[0] + 1 < image.length) {
                    if (image[temp[0] + 1][temp[1]] == image[temp[0]][temp[1]]) {
                        // Down
                        // System.out.println("Case 3");
                        queue.add(new int[] {temp[0] + 1, temp[1]});
                    }

                } if (temp[0] - 1 >= 0) {
                    if (image[temp[0] - 1][temp[1]] == image[temp[0]][temp[1]]) {
                        // Up
                        // System.out.println("Case 4");
                        queue.add(new int[] {temp[0] - 1, temp[1]});
                    }

                }
                image[temp[0]][temp[1]] = newColor;
            }






        }
        return image;
    }
}

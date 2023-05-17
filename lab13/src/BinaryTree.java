import java.util.Arrays;
public class BinaryTree {

    // TODO complete this method
    public static boolean isValid(int[] arr) {
        int index = 1;
        boolean validNumber = false;
        boolean result = false;
        boolean result2 = false;
        while (!validNumber) {
            if (index * 2 + 1 < arr.length - 1) {
                index = index * 2 + 1;
            }

            else if (index * 2 + 1 > arr.length - 1) {
                return false;
            }
            else if (index * 2 + 1 == arr.length - 1) {
                validNumber = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            result = isValidHelper(arr, i, i * 2, "left");
            result2 = isValidHelper(arr, i, i * 2 + 1, "right");
            if (!result || !result2) {
                return false;
            }
        }

        return true;
    }
//    public static boolean isValidHelper(int[] arr, int index, int ptr, String direction) {
//        if (ptr * 2 >= arr.length) {
//            return true;
//        }
//        else {
//            for (int i = 0; i < arr2.length; i++) {
//                if (arr[ptr]
//            }
//        }
//
//    }

    public static boolean isValidHelper(int[] arr, int index, int ptr, String direction) {
        boolean result;
        boolean result2;
        if (ptr >= arr.length) {
//            if (direction == "left" && arr[index] < arr[ptr]) {
//                return false;
//            }
//            if (direction == "right" && arr[index] > arr[ptr]) {
//                return false;
//            }
            return true;
        }
        else {
            if (direction == "left" && arr[index] < arr[ptr]) {
                return false;
            }
            if (direction == "right" && arr[index] > arr[ptr]) {
                return false;
            }
            result = isValidHelper(arr, index, ptr * 2, direction);
            result2 = isValidHelper(arr, index, ptr * 2 + 1, direction);
        }

        return (result && result2);
    }




    public static void main (String args[]) {
      // milestone 1
      int[] arr1 = new int[]{-1,7,4,10,3,6,8,15};
      int[] arr2 = new int[]{-1,20,12,32,5,18,25,38};
      int[] arr3 = new int[]{-1,11,3,33,2,8,10,44};
      int[] arr4 = new int[]{-1,55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};
      int[] arr5  = new int[]{-1,1,2,3,4,5,6,7};

      System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
      System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
      System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
      System.out.println("arr4 valid: " + isValid(arr4));  // expected: false


    }
}

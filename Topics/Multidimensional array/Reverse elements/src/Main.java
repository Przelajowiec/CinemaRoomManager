
class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        int temp;
        int len = twoDimArray[0].length;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < len / 2; j++) {
                temp = twoDimArray[i][j];
                twoDimArray[i][j] = twoDimArray[i][len - 1 - j];
                twoDimArray[i][len - 1 - j] = temp;
            }
        }
    }
}

//    public static void main(String[] args) {
//        int[][] arr = {{0,0,9,9},{1,2,3,4},{5,6,7,8}};
//        reverseElements(arr);
//        for (int i = 0; i < arr.length; i++){
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
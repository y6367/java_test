public class RotateRight {
    public static void rotateRight(int[] list) {
        int last = list[list.length - 1];
        for (int i = list.length - 1; i > 0; i--) {
            list[i] = list[i - 1];
        }
        list[0] = last;
    }

    public static void main(String[] args) {
        int[] result = new int[]{3, 8, 19, 7};
        rotateRight(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
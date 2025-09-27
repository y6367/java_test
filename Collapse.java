public class Collapse {
    public static int[] collapse(int[] list) {
        int[] newList;
        if (list.length % 2 == 1) {
            int listNum = 0;
            newList = new int[(list.length / 2) + 1];
            for (int i = 0; i < newList.length - 1; i++) {
                newList[i] = list[listNum] + list[listNum + 1];
                listNum += 2;
            }
        } else {
            int listNum = 0;
            newList = new int[list.length / 2];
            for (int i = 0; i < newList.length; i++) {
                newList[i] = list[listNum] + list[listNum + 1];
                listNum += 2;
            }
        }
        // TODO: Your code here

        if (list.length % 2 == 1) {
            newList[newList.length - 1] = list[list.length - 1];
        }
        return newList;
    }

    public static void main(String[] args) {
        int[] result = collapse(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
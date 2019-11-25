/* *****************************************************************************
 *  Name: Eli Ji
 *  Date: 10-24-19
 *  Description: Merge Sort
 **************************************************************************** */

public class Merge {
    public static void main(String[] args) {
        int[] list = {5,1,8,5,9,23,54,-3,4};
        sort(list);
        for(int x: list){
            System.out.print(x + " ");
        }
    }

    private static void sort(int list[]){
        sortWrapper(list, 0, list.length - 1);
    }

    private static void sortWrapper(int list[], int leftIndex, int rightIndex) {
        //this condition checks if the subarrays are of length > 0
        if (leftIndex!=rightIndex) {
            int midIndex = (leftIndex + rightIndex)/2;
            //Sort left
            sortWrapper(list, leftIndex, midIndex);
            //Sort right
            sortWrapper(list, midIndex+1, rightIndex);
            //Merge sorted halves together
            merge(list, leftIndex, midIndex, rightIndex);
        }
    }

    private static void merge(int list[], int leftIndex, int midIndex, int rightIndex) {
        int left[] = new int [midIndex - leftIndex + 1];
        for (int i=0; i<left.length; i++) {
            left[i] = list[leftIndex + i];
        }
        int right[] = new int [rightIndex - midIndex];
        for (int j=0; j<right.length; j++) {
            right[j] = list[midIndex + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = leftIndex;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]){
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }
    }
}

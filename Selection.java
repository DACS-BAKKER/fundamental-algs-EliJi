/* *****************************************************************************
 *  Name: Eli Ji
 *  Date: 10-24-19
 *  Description: Selection Sort Implementation
 **************************************************************************** */

public class Selection {
    public static void main(String[] args) {
        int[] list = {5,1,8,5,9,23,54,-3,4};
        sort(list);
        for(int x: list){
            System.out.print(x + " ");
        }
    }

    private static void sort(int[] list){
        for(int j=0;j<list.length-1;j++){
            int min = list[j];
            for(int i=j;i<list.length;i++){
                if(list[i]<min){
                    min=list[i];
                    //swaps min with first number
                    int temp = list[j];
                    list[j] = min;
                    list[i] = temp;
                }
            }
        }
    }
}

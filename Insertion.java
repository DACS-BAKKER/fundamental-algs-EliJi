/* *****************************************************************************
 *  Name: Eli Ji
 *  Date: 10-24-19
 *  Description: Insertion Sort Implementation
 **************************************************************************** */

public class Insertion {
    public static void main(String[] args) {
        int[] list = {5,1,8,5,9,23,54,-3,4};
        sort(list);
        for(int x: list){
            System.out.print(x + " ");
        }
    }

    public static void sort(int[] list){
        for(int i=0; i<list.length; i++){
            for(int j=i; j>0; j--){
                if(list[j]<list[j-1]){
                    int temp = list[j];
                    //swap
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
    }
}

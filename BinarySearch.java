/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = {1, 20 , 54, 72 , 146, 200, 566};
        System.out.println(search(list, 566));
    }

    public static int search(int[] list, int num){
        int mid = list.length/2;
        int currNum = list[mid];
        while(currNum!=num){
            if(currNum > num){
                mid = mid/2;
                currNum = list[mid];
            }else if(currNum < num){
                mid = (mid + list.length)/2;
                currNum = list[mid];
            }
        } return currNum;
    }
}

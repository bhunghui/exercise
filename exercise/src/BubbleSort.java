public class BubbleSort {
    public static void main(String[] args){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i;
        }
        display(arr);
        BubbleSort(arr);
        System.out.println("");
        display(arr);
        int[] arr2 = new int[] {31,2,8,1,8,24,7,10,99,0};
        display(arr2);
        BubbleSort(arr2);
        display(arr2);
    }

    public static void BubbleSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

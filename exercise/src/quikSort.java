public class quikSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i;
        }
        display(arr);
        System.out.println("");
        quikSort(arr, 0, arr.length - 1);
        display(arr);
        int[] arr2 = new int[] {31,2,8,1,8,24,7,10,99,0};
        quikSort(arr2, 0 ,arr2.length - 1);
        display(arr2);
    }

    public static void quikSort(int[] arr, int start, int end) {
        if (start > end) {return;}
        int standard = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (arr[j] >= standard && i < j) { j--; }
            while (arr[i] <= standard && i < j) { i++; }
            if (i != j) {
                swap(arr, i, j);
            } else {
                swap(arr, start, i);
                break;
            }
        }
        quikSort(arr, start, i - 1);
        quikSort(arr, i + 1, end);
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


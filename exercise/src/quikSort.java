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
        int[] arr2 = new int[] {4,2,8,1,8};
        quikSort(arr2, 0 ,arr2.length - 1);
        display(arr2);
    }

    public static void quikSort(int[] arr, int start, int end) {
        int left = start, right = end;
        if (start == end) {return;}
        int standard = arr[arr.length >> 1];
        while (left < right) {
            while (arr[left] < standard) {
                if (left < right) {
                    left++;
                }else{
                    return;
                }
            }
            while (arr[right] > standard) {
                if (right > left) {
                    right--;
                }else {
                    return;
                }
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            if ( left < right) {
                left++;
                right--;
            }else {
                return;
            }
        }
        quikSort(arr, start, left);
        quikSort(arr, right, end);
    }
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}

//Программа написана в процедурной, структурной парадигме
class Main {
    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 5;

        int index = binarySearch(array1, x);

        if (index != -1) {
            System.out.println("Индекс элемента: " + index);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    private static int binarySearch(int[]arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                return mid;
            }
            else if (x > arr[mid]) {
                left = mid + 1;
            }
            else
                right = mid - 1;


        }

        return -1;
    }


}





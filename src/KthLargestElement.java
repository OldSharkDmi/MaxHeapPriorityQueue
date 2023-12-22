import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElement {
    //Доказать что быстрая реализация

    /*
   19.Разработка алгоритма для реализации MaxHeap,
    которая поддерживает быстрое получение k-го по величине элемента.
    использую бинар кучу (PriorityQueue)
    */

    public static long startHeap;
    public static long endHeap;
    public static long startSelectSort;
    public static long endSelectSort;

    public static int findKthLargestWithHeap(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("оч большой k");
        }
        // создаемс MaxHeap с использованием PriorityQueue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // добавляем все элементы массива в MaxHeap
        for (int num : nums) {
            maxHeap.offer(num);
        }
         startHeap = System.nanoTime();
        // ипзвлекаем k максимальный элемент
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }
         endHeap = System.nanoTime();
        System.out.println("Время: " + (endHeap - startHeap) + " наносекунд");
        return result;
    }





    public static int[] generateRandomArray(int size) {
        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(999);
        }

        return nums;
    }

//O(n * k)
    public static int findKthLargestSelect(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("оч большой k");
        }

        int n = nums.length;
         startSelectSort = System.nanoTime();
        for (int i = 0; i < k; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }

         endSelectSort = System.nanoTime();
        System.out.println("Время: " + (endSelectSort  - startSelectSort ) + " наносекунд");
        return nums[k - 1];
    }


    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }



    // O(n^2)
    /*
    public static int findKthLargestNaive(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("оч большой k");
        }

        bubbleSort(nums);

        // звлекаем k-й максимальный элемент
        return nums[nums.length - k];
    }

    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] > nums[i]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

     */

}

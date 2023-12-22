import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание  1,2,3: ");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                demonstratePriorityQueue();
                break;
            case "2":
                demonstrateMaxHeap();
                break;
            case "3":
                demonstrateKthLargestElement();
                break;
            default:
                System.out.println("Некорректный ввод.");
        }
    }


    private static void demonstratePriorityQueue() {
        System.out.println("Очередь с приоритетом:");
        AbstractQueue<Integer> priorityQueue = new CustomPriorityQueue<>();

        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(20);
        priorityQueue.add(15);
        System.out.println("Size: " + priorityQueue.size());
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("Poll: " + priorityQueue.poll());
        System.out.println("Size after poll: " + priorityQueue.size());
    }

    private static void demonstrateMaxHeap() {
        System.out.println("Макс бианраня куча:");
        Heap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(15);

        System.out.println("Size: " + maxHeap.size());
        System.out.println("Peek: " + maxHeap.peek());
    }

    private static void demonstrateKthLargestElement() {
        System.out.println("Поиск K-ого по величине элемента:");
        int[] nums = KthLargestElement.generateRandomArray(10000);
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        int[] nums3 = Arrays.copyOf(nums, nums.length);
        int k = 3254;


        System.out.println("Использование бинарной кучи ");
        long startHeap = System.nanoTime();
        int resultHeap = KthLargestElement.findKthLargestWithHeap(nums1, k);
        long endHeap = System.nanoTime();
        System.out.println("К-й элемент: " + resultHeap);
        System.out.println("Время: " + (endHeap - startHeap) + " милисекунд");

        //  время выполнения с использованием метода выбора
        System.out.println("Использование алгоритма выбора для поиска ");
        long startSelectSort = System.nanoTime();
        int resultSelectSort = KthLargestElement. findKthLargestSelect(nums2, k);
        long endSelectSort = System.nanoTime();
        System.out.println("К-й элемент: " + resultSelectSort );
        System.out.println("Время: " + (endSelectSort  - startSelectSort ) + " милисекунд");

        //  время выполнения с использованием сортировки пузырьком
        System.out.println("Использование сортировки пузырьком для поиска ");
        long startSort = System.nanoTime();
        int resultSorting = KthLargestElement.findKthLargestNaive(nums3, k);
        long endSort = System.nanoTime();
        System.out.println("К-й элемент: " + resultSorting);
        System.out.println("Время: " + (endSort - startSort) + " милисекунд");

        long heapTime = (endHeap - startHeap);
        long sortTime = (endSort - startSort);
        long selectSortTime =(endSelectSort -startSelectSort);
        System.out.println("Разница сортировки пузырьком и бинарной кучи: "+ (sortTime-heapTime)+ " милисекунд");
        System.out.println("Разница методом выбора и бинарной кучи: "+ (selectSortTime-heapTime)+ " милисекунд");


    }
}

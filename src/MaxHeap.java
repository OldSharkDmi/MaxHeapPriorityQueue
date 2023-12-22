import java.util.ArrayList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    //юзаем максимальную бинарную кучу
    // хранение элементов кучи
    private List<E> heap;

    //  созданик новой максимальной бинарной кучи
    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    // текущий размер кучи (количество элементов)
    @Override
    public int size() {
        return heap.size();
    }

    // добавляем новый элемент в кучу и восстанавливаем свойства максимальной кучи
    @Override
    public void add(E element) {
        heap.add(element);
        heapifyUp(size() - 1);  // поднимаем элемент вверх по куче
    }

    // максимальный элемент без удаления
    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        }
        return heap.get(0);  // возвращаем корень кучи (максимальный элемент)
    }

    // поднимаем элемент вверх по куче, чтобы восстановить свойства максимальной кучи
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            // если текущий элемент больше его родителя, меняем их местами ну компаратор))
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;  // пекращаем подниматься, если свойства кучи восстановлены
            }
        }
    }

    // Меняет местами два элемента в списке
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }



}

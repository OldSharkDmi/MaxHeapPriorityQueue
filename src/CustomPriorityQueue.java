import java.util.ArrayList;
import java.util.List;

public class CustomPriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    // хранение элементов очереди
    private List<E> elements;

    // создани новой очереди
    public CustomPriorityQueue() {
        this.elements = new ArrayList<>();
    }

    // текущий размер очереди
    @Override
    public int size() {
        return elements.size();
    }

    // добавляем новый элемент в очередь и восстанавливаем свойства кучи
    @Override
    public void add(E element) {
        elements.add(element);
        heapifyUp(size() - 1);
    }

    // возвращаем максимальный элемент без удаления
    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        }
        return elements.get(0);
    }

    // Извлекаем и возвращаем максимальный элемент, восстанавливая свойства кучи
    @Override
    public E poll() {
        if (size() == 0) {
            return null;
        }

        // Сохраняем корневой элемент
        E root = elements.get(0);

        // Заменяем корневой элемент последним элементом
        E lastElement = elements.remove(size() - 1);
        if (size() > 0) {
            elements.set(0, lastElement);
            heapifyDown(0);
        }

        return root;
    }

    // Поднимает элемент вверх по куче, чтобы восстановить свойства кучи
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            // Если элемент больше родителя, меняем их местами
            if (elements.get(index).compareTo(elements.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Опускает элемент вниз по куче, чтобы восстановить свойства кучи
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        // Находим наибольший из дочерних элементов
        if (leftChildIndex < size() && elements.get(leftChildIndex).compareTo(elements.get(largest)) > 0) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < size() && elements.get(rightChildIndex).compareTo(elements.get(largest)) > 0) {
            largest = rightChildIndex;
        }

        // Если нашелся больший дочерний элемент, меняем местами с текущим
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Меняет местами два элемента в списке
    private void swap(int i, int j) {
        E temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}

import java.util.Arrays;

// Метод сортировки выбором

public class Project {
    public static void main(String[] args) {
        int[] unsortedArray = {1, 2, 3, 4, 8, 6, 7, 5};
        System.out.println(Arrays.toString(unsortedArray));
        choiceSort(unsortedArray);
        bubbleSort(unsortedArray);
        insertSort(unsortedArray);
    }

    public static void choiceSort(int[] arrayToSort) {

        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        System.out.println("Сортировка выбором");
        //Проходим по массиву
        //Найти минимальный элемент
        //Меняем местами первый и минимальный элемент

        long start = System.nanoTime();

        int indexMin;
        for (int index = 0; index < arrayToSort.length - 1; index++) {
            indexMin = index;
            for (int indexToScan = index; indexToScan < arrayToSort.length; indexToScan++) {
                if (arrayToSort[indexMin] > arrayToSort[indexToScan]) {
                    indexMin = indexToScan;

                }
            }
            int temp = arrayToSort[index];
            arrayToSort[index] = arrayToSort[indexMin];
            arrayToSort[indexMin] = temp;
        }

        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(arrayToSort));
    }

    //метод пузырька

    public static void bubbleSort(int[] arrayToSort) {

        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        System.out.println("Метод пузырька");
        //проходим по массиву
        //сравнить два соседних элемента
        //повторить, пока не отсортируем

        long start = System.nanoTime();

        int changeCounter;

        do {
            changeCounter = 0;
            for (int index = 0; index < arrayToSort.length - 1; index++) {
                if (arrayToSort[index] > arrayToSort[index + 1]) {
                    int temp = arrayToSort[index];
                    arrayToSort[index] = arrayToSort[index + 1];
                    arrayToSort[index + 1] = temp;
                    changeCounter++;
                }
            }
        } while (changeCounter > 0);
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(arrayToSort));

    }

    //сортировка вставками

    public static void insertSort(int[] arrayToSort) {

        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        System.out.println("Сортировка вставками");
        //пройти по массиву
        //выбираем элемент
        //устанавливаем элемент на законное место

        long start = System.nanoTime();

        int element;
        int indexToInsert;

        for (int index = 0; index < arrayToSort.length; index++) {
            element = arrayToSort[index];

            indexToInsert = index;

            while (indexToInsert > 0
                    && arrayToSort[indexToInsert - 1] > element) {
                arrayToSort[indexToInsert] = arrayToSort[indexToInsert - 1];
                indexToInsert--;
                arrayToSort[indexToInsert] = element;
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(arrayToSort));
    }
}



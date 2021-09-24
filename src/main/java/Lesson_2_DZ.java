/*
1.  Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
2.  Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3.  Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4.  Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
5.  ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6.  ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
7.  **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
*/


public class Lesson_2_DZ {
    public static void main(String[] args) {
        /**
         * Task_1
         */
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] > 0 ? 0 : 1);
        }

        /**
         * Task_2
         */
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i * 3;
        }

        /**
         * Task_3
         */
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (array3[i] < 6 ? array3[i] *= 2 : array3[i]);
        }

        /**
         * Task_4
         */
        int[][] array4 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array4[i][j] = ((i == j) || (i + j == 4) ? 1 : array4[i][j]);
            }
        }

        /**
         * Task_5
         */
        int[] array5 = {1, 5, 3, 2, 11, 4, 5, 2, -4, 8, 9, 1};
        int max = array5[0];
        int min = array5[0];
        for (int i = 1; i < array5.length; i++) {
            max = (array5[i] > max ? array5[i] : max);
            min = (array5[i] < min ? array5[i] : min);
        }

        /**
         * Task_6
         */
        int[] array6 = {1, 1, 1, 3, 2, 4};
        checkBalance(array6);

        /**
         * Task_7
         */
        int[] array7 = {1, 2, 3, 4, 5, 6};
        arrayMoving(array7, -5);
    }

    //task_6
    public static boolean checkBalance(int[] arr) {
        int sumLeft = 0; //сумма элементов массива слева от предполагаемой границы баланса
        int sumRight = 0; //сумма элементов массива справа от предполагаемой границы баланса
        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft += arr[i];
            int temp = 0; // временная переменная для передачи суммы в sumRight
            for (int j = i + 1; j < arr.length; j++) {
                temp += arr[j]; //подсчет суммы от sumLeft до конца массива
                sumRight = temp;
            }
            if (sumLeft == sumRight)
                break;
        }
        return sumLeft == sumRight;
    }

    //task_7
    public static void arrayMoving(int[] arr, int n) {
        if (n > 0) { // сдвиг массива вправо на n позиций
            for (int i = 0; i < n; i++) {
                int temp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = temp;
            }
        }

        if (n < 0) { // сдвиг массива влево на n позиций
            for (int i = 0; i < -n; i++) {
                int temp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = temp;
            }
        }
    }
}
package ru.businessTechnology;

//СОРТИРОВКА ВСТАВКАМИ. Суть: при каждой итерации сравниваем i элемент со всеми остальными и меняем местами
//при необходимости. Таким образом, на позиции i в результате каждой итерации будет мин. элемент
public class InsertSort {
    //Сложность O(n^2)
    public static void choiceSort(int [] inputArray){
        int size = inputArray.length;
        int minElemPos;
        int tempValue;
        for (int i = 0; i < size-1; i++) { //последний элемент сравнивать ни с чем не нужно
            minElemPos = i; //с каждой итерацией устанавливаем по умолчанию мин элемент i
            for (int j = i+1; j < size; j++) {
                if (inputArray[j] < inputArray[minElemPos]) minElemPos = j;
            }
            if (i != minElemPos){ //если это не изначальный элемент то:
                tempValue = inputArray[i];
                inputArray[i] = inputArray[minElemPos];
                inputArray[minElemPos] = tempValue;
            }
        }
    }
}

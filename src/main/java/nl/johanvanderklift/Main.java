package nl.johanvanderklift;

import java.util.Random;

public class Main {
  public static void main(String[] args) {

    int[] inputArray = new int[100];
    Random rand = new Random();

    for (int i = 0; i < inputArray.length; i++) {
      inputArray[i] = rand.nextInt(10000);
    }

    System.out.println("Before: ");
    printArray(inputArray);

    quickSort(inputArray);

    System.out.println("\nAfter: ");
    printArray(inputArray);
  }

  private static void quickSort(int[] inputArray) {
    quickSort(inputArray, 0, inputArray.length - 1);
  }

  private static void quickSort(int[] inputArray, int lowIndex, int highIndex) {

    if (lowIndex >= highIndex) {
      return;
    }

    int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
    int pivot = inputArray[pivotIndex];
    swap(inputArray, pivotIndex, highIndex);

    int leftPointer = partition(inputArray, lowIndex, highIndex, pivot);

    quickSort(inputArray, lowIndex, leftPointer - 1);
    quickSort(inputArray, leftPointer + 1, highIndex);

  }

  private static int partition(int[] inputArray, int lowIndex, int highIndex, int pivot) {
    int leftPointer = lowIndex;
    int rightPointer = highIndex;

    while (leftPointer < rightPointer) {
      while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }

      while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }

      swap(inputArray, leftPointer, rightPointer);
    }

    swap(inputArray, leftPointer, highIndex);
    return leftPointer;
  }

  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  private static void printArray(int[] inputArray) {
    for (int number : inputArray) {
      System.out.println(number);
    }
  }
}
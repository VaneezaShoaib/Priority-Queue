// Name: Vaneeza Shoaib
// Computing ID: ZHW9ZC@virginia.edu
// Homework Name: HW 12
// Resources used: ChatAI- upward and downward for debugging

package pq;

import java.util.*;

public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T> {
    private int size = 0; //Keeps track of the number of elements in the heap that represents a priority queue
    private ArrayList<T> heap; //Uses an ArrayList to implement the heap that represents a priority queue

    // Constructor
    public MyPriorityQueue() {
        heap = new ArrayList<T>(); //Initializes a new ArrayList
    }

    // Add an element to the priority queue
    @Override
    public void add(T element) {
        heap.add(element);
        size++;
        upward(heap.size() - 1);
    }

    // Remove all elements from the priority queue
    @Override
    public void clear() {
        heap = new ArrayList<T>();
        size = 0;
    }

    // Check if the priority queue contains a specific element
    @Override
    public boolean contains(Object obj) {
        if (heap.size() == 0) {
            return false;
        }
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).equals(obj)) { //If this is a priority queue of Tasks, this method calls the .equals method in the Task class
                return true;
            }
        }
        return false;
    }

    // Return the item with the highest priority (peek)
    @Override
    public T peek() {
        if (heap.size() == 0) {
            return null;
        }
        else {
            return heap.get(0);
        }
    }

    // Remove and return the item with the highest priority
    @Override
    public T remove() {
        if (heap.size() == 0) {
            return null;
        }

        // Swap the root with the last element and remove the last element
        swap(0, heap.size()-1);
        T toRemove = heap.remove(heap.size() - 1); //Removes the last element in the heap
        downward(0); //Fixes the Arraylist so that it maintains heap properties
        size--;
        return toRemove;
    }

    // Return the number of elements in the priority queue
    @Override
    public int size() {
        return heap.size();
    }

    // Helper method to maintain heap property after insertion
    private void upward(int i) {
        if (i == 0) { //Base case
            return;
        }
        int parent= (i - 1) / 2;
        if (heap.get(parent).compareTo(heap.get(i)) < 0) {
            //Checks to see if the parent value is less than the child value
            swap(i, parent); //Swaps the parent and the child
            upward(parent); //Recursively calls the upward method
        }
    }

    private void swap(int first, int second) { //Helper method to swap two elements in the heap
        T one =  heap.get(first);
        T two = heap.get(second);
        heap.set(first, two);
        heap.set(second, one);
    }

    // Helper method to maintain heap property after removal
    private void downward(int i) {
        int num = i;
        int left = 2 * i + 1;


        if (left < heap.size() && heap.get(left).compareTo(heap.get(num)) > 0) {
            //Checks to see if the value of the left child is greater than the value of the parent
            num = left;
        }
        int right = 2 * i + 2;

        if (right < heap.size() && heap.get(right).compareTo(heap.get(num)) > 0) {
            //Checks to see if the value of the right child is greater than the value of the parent
            num = right;
        }
        if (num != i) {
            swap(i, num);
            downward(num);
        }
    }
    // toString method to represent the contents of the priority queue
    @Override
    public String toString() {
        return heap.toString();
    }
}
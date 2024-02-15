package hogwarts.application;

import generic.Person;

public class DynamicArray {

  private Person[] array;
  private int size;
  private int capacity;
  private final int growsize = 10;
  private final int initialsize = 10;

  // constructor for the array.
  public DynamicArray() {
    this.capacity = initialsize;
    this.array = new Person[capacity];
    this.size = 0;
  }

  // add new person object to array.
  public void add(Person element) {
    if (size == capacity) {
      grow();
    }
    array[size] = element;
    size++;
  }

  private void grow() {
    int newCapacity = capacity + growsize;
    Person[] newArray = new Person[newCapacity];
    // Copy elements from the old array to the new array
    for (int i = 0; i < size; i++) {
      newArray[i] = array[i];
    }
    // Implement new array.
    array = newArray;
    // Implement new capacity.
    capacity = newCapacity;
  }

  private void shrink() {
    if (canShrink()) {
      int newCapacity = capacity - growsize;
      Person[] newArray = new Person[newCapacity];
      for (int i = 0; i < size; i++) {
        newArray[i] = array[i];
      }
      array = newArray;
      capacity = newCapacity;
    } else {
      System.out.println("Could not shrink array as conditions were not met.");
    }
  }

  // Function for removing a specific generic.Person object from the array.
  public void remove(int index) {
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    // remove last element and decrease size.
    array[size - 1] = null;
    size--;
    // Check if array can shrink
    if (canShrink()) {
      shrink();
    }
  }

  public int size() {
    return size;
  }

  public int capacity() {
    return capacity;
  }

  public void printAll() {
    for (int i = 0; i < size; i++) {
      System.out.println(array[i]);
    }
  }

  public boolean canShrink() {
    if (
      array.length > size &
      (array.length - size) > growsize &
      (array.length - growsize) > initialsize
    ) {
      return true;
    } else {
      return false;
    }
  }

  public void clear() {
    size = 0;
  }

  public Person get(int index) {
    return array[index];
  }

  public void set(int index, Person object) {
    array[index] = object;
  }
}

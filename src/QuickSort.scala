class Quicksort {
  var numbers: Array[Int] = _
  var number = 0;

  def sort(values: Array[Int]) {
    // Check for empty or null array
    if (values == null || values.length == 0) {
      return ;
    }
    this.numbers = values;
    number = values.length;
    quicksort(0, number - 1);
  }

  def quicksort(low: Int, high: Int) {
    var i = low
    var j = high
    // Get the pivot element from the middle of the list
    val pivot = numbers(low + (high - low) / 2)

    // Divide into two lists
    while (i <= j) {
      // If the current value from the left list is smaller then the pivot
      // element then get the next element from the left list
      while (numbers(i) < pivot) {
        i = i + 1;
      }
      // If the current value from the right list is larger then the pivot
      // element then get the next element from the right list
      while (numbers(j) > pivot) {
        j = j - 1;
      }

      // If we have found a values in the left list which is larger then
      // the pivot element and if we have found a value in the right list
      // which is smaller then the pivot element then we exchange the
      // values.
      // As we are done we can increase i and j
      if (i <= j) {
        exchange(i, j);
        i = i + 1
        j = j - 1
      }
    }
    // Recursion
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
  }

  def exchange(i: Integer, j: Integer) {
    val temp = numbers(i);
    numbers(i) = numbers(j)
    numbers(j) = temp;
  }
}
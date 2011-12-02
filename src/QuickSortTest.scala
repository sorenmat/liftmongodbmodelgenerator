import scala.util.Random
object QuickSortTest {
  def main(args: Array[String]) = {
    val quicksort = new Quicksort
    val randomGenerator = new Random()

    for (i <- 1 to 10) {
      val range = (0 until 1000000)
      val a = range.map(f => randomGenerator.nextInt(1000)).toArray
      System.currentTimeMillis
      val start = System.currentTimeMillis()
      val sorted = quicksort.sort(a) 
      val stop = System.currentTimeMillis()
      println("Scala Sorting took: " + (stop - start))
    }

  }
}
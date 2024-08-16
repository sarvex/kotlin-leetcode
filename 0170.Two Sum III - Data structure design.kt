internal class TwoSum {
  private val cnt: Map<Int, Int> = HashMap()

  fun add(number: Int) {
    cnt.merge(number, 1) { a: Int, b: Int -> Integer.sum(a, b) }
  }

  fun find(value: Int): Boolean {
    for (e in cnt.entrySet()) {
      val x: Int = e.getKey()
      val v: Int = e.getValue()
      val y = value - x
      if (cnt.containsKey(y) && (x != y || v > 1)) {
        return true
      }
    }
    return false
  }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

internal class PhoneDirectory(maxNumbers: Int) {
  private val available: Set<Int> = HashSet()

  init {
    for (i in 0 until maxNumbers) {
      available.add(i)
    }
  }

  fun get(): Int {
    if (available.isEmpty()) {
      return -1
    }
    val x = available.iterator().next()
    available.remove(x)
    return x
  }

  fun check(number: Int): Boolean {
    return available.contains(number)
  }

  fun release(number: Int) {
    available.add(number)
  }
}
/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */

internal class RLEIterator(private val encoding: IntArray) {
  private var i = 0
  private var j = 0

  fun next(n: Int): Int {
    var n = n
    while (i < encoding.size) {
      if (encoding[i] - j < n) {
        n -= (encoding[i] - j)
        i += 2
        j = 0
      } else {
        j += n
        return encoding[i + 1]
      }
    }
    return -1
  }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */

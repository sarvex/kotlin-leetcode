internal class MovingAverage(size: Int) {
  private val arr = IntArray(size)
  private var s = 0
  private var cnt = 0

  fun next(`val`: Int): Double {
    val idx = cnt % arr.size
    s += `val` - arr[idx]
    arr[idx] = `val`
    ++cnt
    return s * 1.0 / min(cnt, arr.size)
  }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

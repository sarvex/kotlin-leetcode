internal class CustomStack(maxSize: Int) {
  private val stk = IntArray(maxSize)
  private val add = IntArray(maxSize)
  private var i = 0

  fun push(x: Int) {
    if (i < stk.size) {
      stk[i++] = x
    }
  }

  fun pop(): Int {
    if (i <= 0) {
      return -1
    }
    val ans = stk[--i] + add[i]
    if (i > 0) {
      add[i - 1] += add[i]
    }
    add[i] = 0
    return ans
  }

  fun increment(k: Int, `val`: Int) {
    if (i > 0) {
      add[min(i, k) - 1] += `val`
    }
  }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

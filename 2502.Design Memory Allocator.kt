import java.util.*

internal class Allocator(n: Int) {
  private val m = IntArray(n)

  fun allocate(size: Int, mID: Int): Int {
    var cnt = 0
    for (i in m.indices) {
      if (m[i] > 0) {
        cnt = 0
      } else if (++cnt == size) {
        Arrays.fill(m, i - size + 1, i + 1, mID)
        return i - size + 1
      }
    }
    return -1
  }

  fun free(mID: Int): Int {
    var ans = 0
    for (i in m.indices) {
      if (m[i] == mID) {
        m[i] = 0
        ++ans
      }
    }
    return ans
  }
}
/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */

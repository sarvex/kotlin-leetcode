internal class Solution {
  fun findOriginalArray(changed: IntArray): IntArray {
    val n = changed.size
    Arrays.sort(changed)
    val cnt = IntArray(changed[n - 1] + 1)
    for (x in changed) {
      ++cnt[x]
    }
    val ans = IntArray(n shr 1)
    var i = 0
    for (x in changed) {
      if (cnt[x] == 0) {
        continue
      }
      --cnt[x]
      val y = x shl 1
      if (y >= cnt.size || cnt[y] <= 0) {
        return IntArray(0)
      }
      --cnt[y]
      ans[i++] = x
    }
    return ans
  }
}

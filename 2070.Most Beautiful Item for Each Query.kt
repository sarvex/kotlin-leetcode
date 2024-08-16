internal class Solution {
  fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
    Arrays.sort(items) { a, b -> a.get(0) - b.get(0) }
    val n = items.size
    val m = queries.size
    val ans = IntArray(m)
    val idx: Array<Int> = arrayOfNulls(m)
    for (i in 0 until m) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> queries[i] - queries[j] }
    var i = 0
    var mx = 0
    for (j in idx) {
      while (i < n && items[i][0] <= queries[j]) {
        mx = max(mx, items[i][1])
        ++i
      }
      ans[j] = mx
    }
    return ans
  }
}

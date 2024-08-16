internal class Solution {
  fun averageHeightOfBuildings(buildings: Array<IntArray>): Array<IntArray> {
    val cnt: Map<Int, Int> = HashMap()
    val d: TreeMap<Int, Int> = TreeMap()
    for (e in buildings) {
      val start = e[0]
      val end = e[1]
      val height = e[2]
      cnt.merge(start, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(end, -1) { a: Int, b: Int -> Integer.sum(a, b) }
      d.merge(start, height) { a: Int, b: Int -> Integer.sum(a, b) }
      d.merge(end, -height) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var s = 0
    var m = 0
    var last = -1
    val ans: List<IntArray> = ArrayList()
    for (e in d.entrySet()) {
      val k: Int = e.getKey()
      val v: Int = e.getValue()
      if (m > 0) {
        val avg = s / m
        if (!ans.isEmpty() && ans[ans.size() - 1][2] === avg && ans[ans.size() - 1][1] === last) {
          ans[ans.size() - 1][1] = k
        } else {
          ans.add(intArrayOf(last, k, avg))
        }
      }
      s += v
      m += cnt[k]!!
      last = k
    }
    return ans.toArray(arrayOfNulls<IntArray>(0))
  }
}

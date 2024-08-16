internal class Solution {
  fun sortFeatures(features: Array<String>, responses: Array<String>): Array<String> {
    val cnt: Map<String, Int> = HashMap()
    for (s in responses) {
      val vis: Set<String> = HashSet()
      for (w in s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
        if (vis.add(w)) {
          cnt.merge(w, 1) { a: Int, b: Int -> Integer.sum(a, b) }
        }
      }
    }
    val n = features.size
    val idx: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j ->
      val x = cnt.getOrDefault(features[i], 0)
      val y = cnt.getOrDefault(features[j], 0)
      if (x == y) i - j else y - x
    }
    val ans: Array<String> = arrayOfNulls(n)
    for (i in 0 until n) {
      ans[i] = features[idx[i]]
    }
    return ans
  }
}

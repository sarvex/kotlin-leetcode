internal class Solution {
  fun subarrayBitwiseORs(arr: IntArray): Int {
    val ans: Set<Int> = HashSet()
    var s: Set<Int> = HashSet()
    for (x in arr) {
      val t: Set<Int> = HashSet()
      for (y in s) {
        t.add(x or y)
      }
      t.add(x)
      ans.addAll(t)
      s = t
    }
    return ans.size()
  }
}

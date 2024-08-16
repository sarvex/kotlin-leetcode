internal class Solution {
  fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
    val last: Map<Char, Int> = HashMap(3)
    var ans = 0
    for (i in garbage.indices) {
      val s = garbage[i]
      ans += s.length
      for (c in s.toCharArray()) {
        last.put(c, i)
      }
    }
    var ts = 0
    for (i in 1..travel.size) {
      ts += travel[i - 1]
      for (j in last.values()) {
        if (i == j) {
          ans += ts
        }
      }
    }
    return ans
  }
}

internal class Solution {
  fun closestToTarget(arr: IntArray, target: Int): Int {
    var ans: Int = abs(arr[0] - target)
    var pre: Set<Int> = HashSet()
    pre.add(arr[0])
    for (x in arr) {
      val cur: Set<Int> = HashSet()
      for (y in pre) {
        cur.add(x and y)
      }
      cur.add(x)
      for (y in cur) {
        ans = min(ans, abs(y - target))
      }
      pre = cur
    }
    return ans
  }
}

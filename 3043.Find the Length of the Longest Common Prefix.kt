internal class Solution {
  fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (x in arr1) {
      var x = x
      while (x > 0) {
        s.add(x)
        x /= 10
      }
    }
    var ans = 0
    for (x in arr2) {
      var x = x
      while (x > 0) {
        if (s.contains(x)) {
          ans = max(ans, x.toString().length)
          break
        }
        x /= 10
      }
    }
    return ans
  }
}

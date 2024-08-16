internal class Solution {
  fun maximumSum(arr: IntArray): Int {
    val n = arr.size
    val left = IntArray(n)
    val right = IntArray(n)
    var ans = -(1 shl 30)
    run {
      var i = 0
      var s = 0
      while (i < n) {
        s = max(s, 0) + arr[i]
        left[i] = s
        ans = max(ans, left[i])
        ++i
      }
    }
    run {
      var i = n - 1
      var s = 0
      while (i >= 0) {
        s = max(s, 0) + arr[i]
        right[i] = s
        --i
      }
    }
    for (i in 1 until n - 1) {
      ans = max(ans, left[i - 1] + right[i + 1])
    }
    return ans
  }
}

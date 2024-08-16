internal class Solution {
  fun minOperations(boxes: String): IntArray {
    val n = boxes.length
    val left = IntArray(n)
    val right = IntArray(n)
    run {
      var i = 1
      var cnt = 0
      while (i < n) {
        if (boxes[i - 1] == '1') {
          ++cnt
        }
        left[i] = left[i - 1] + cnt
        ++i
      }
    }
    run {
      var i = n - 2
      var cnt = 0
      while (i >= 0) {
        if (boxes[i + 1] == '1') {
          ++cnt
        }
        right[i] = right[i + 1] + cnt
        --i
      }
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = left[i] + right[i]
    }
    return ans
  }
}

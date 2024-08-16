internal class Solution {
  fun findLengthOfShortestSubarray(arr: IntArray): Int {
    val n = arr.size
    var i = 0
    var j = n - 1
    while (i + 1 < n && arr[i] <= arr[i + 1]) {
      ++i
    }
    while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
      --j
    }
    if (i >= j) {
      return 0
    }
    var ans: Int = min(n - i - 1, j)
    for (l in 0..i) {
      val r = search(arr, arr[l], j)
      ans = min(ans, r - l - 1)
    }
    return ans
  }

  private fun search(arr: IntArray, x: Int, left: Int): Int {
    var left = left
    var right = arr.size
    while (left < right) {
      val mid = (left + right) shr 1
      if (arr[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}

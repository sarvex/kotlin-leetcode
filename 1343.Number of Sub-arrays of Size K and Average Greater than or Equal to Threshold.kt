internal class Solution {
  fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    var threshold = threshold
    threshold *= k
    var s = 0
    for (i in 0 until k) {
      s += arr[i]
    }
    var ans = if (s >= threshold) 1 else 0
    for (i in k until arr.size) {
      s += arr[i] - arr[i - k]
      ans += if (s >= threshold) 1 else 0
    }
    return ans
  }
}

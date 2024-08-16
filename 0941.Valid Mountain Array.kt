internal class Solution {
  fun validMountainArray(arr: IntArray): Boolean {
    val n = arr.size
    if (n < 3) {
      return false
    }
    var i = 0
    var j = n - 1
    while (i + 1 < n - 1 && arr[i] < arr[i + 1]) {
      ++i
    }
    while (j - 1 > 0 && arr[j - 1] > arr[j]) {
      --j
    }
    return i == j
  }
}

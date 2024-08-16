internal class Solution {
  fun twoSum(numbers: IntArray, target: Int): IntArray {
    var i = 0
    val n = numbers.size
    while (true) {
      val x = target - numbers[i]
      var l = i + 1
      var r = n - 1
      while (l < r) {
        val mid = (l + r) shr 1
        if (numbers[mid] >= x) {
          r = mid
        } else {
          l = mid + 1
        }
      }
      if (numbers[l] == x) {
        return intArrayOf(i + 1, l + 1)
      }
      ++i
    }
  }
}

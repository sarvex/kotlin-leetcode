internal class Solution {
  fun totalFruit(fruits: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    var ans = 0
    var i = 0
    var j = 0
    while (i < fruits.size) {
      val x = fruits[i]
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      while (cnt.size() > 2) {
        val y = fruits[j++]
        if (cnt.merge(y, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          cnt.remove(y)
        }
      }
      ans = max(ans, i - j + 1)
      ++i
    }
    return ans
  }
}

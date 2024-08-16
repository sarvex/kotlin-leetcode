internal class Solution {
  fun findEvenNumbers(digits: IntArray): IntArray {
    val cnt = IntArray(10)
    for (x in digits) {
      ++cnt[x]
    }
    val ans: List<Int> = ArrayList()
    var x = 100
    while (x < 1000) {
      val cnt1 = IntArray(10)
      var y = x
      while (y > 0) {
        ++cnt1[y % 10]
        y /= 10
      }
      var ok = true
      var i = 0
      while (i < 10 && ok) {
        ok = cnt[i] >= cnt1[i]
        ++i
      }
      if (ok) {
        ans.add(x)
      }
      x += 2
    }
    return ans.stream().mapToInt { i -> i }.toArray()
  }
}

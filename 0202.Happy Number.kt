internal class Solution {
  fun isHappy(n: Int): Boolean {
    var n = n
    val vis: Set<Int> = HashSet()
    while (n != 1 && !vis.contains(n)) {
      vis.add(n)
      var x = 0
      while (n != 0) {
        x += (n % 10) * (n % 10)
        n /= 10
      }
      n = x
    }
    return n == 1
  }
}

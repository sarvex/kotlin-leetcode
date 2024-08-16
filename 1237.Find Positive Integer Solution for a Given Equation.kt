/*
* // This is the custom function interface.
* // You should not implement it, or speculate about its implementation
* class CustomFunction {
*     // Returns f(x, y) for any given positive integers x and y.
*     // Note that f(x, y) is increasing with respect to both x and y.
*     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
*     public int f(int x, int y);
* };
*/
internal class Solution {
  fun findSolution(customfunction: CustomFunction, z: Int): List<List<Int>> {
    val ans: List<List<Int>> = ArrayList()
    for (x in 1..1000) {
      var l = 1
      var r = 1000
      while (l < r) {
        val mid = (l + r) shr 1
        if (customfunction.f(x, mid) >= z) {
          r = mid
        } else {
          l = mid + 1
        }
      }
      if (customfunction.f(x, l) === z) {
        ans.add(Arrays.asList(x, l))
      }
    }
    return ans
  }
}

internal class Solution {
  fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val cnt: Map<Int, Int> = HashMap()
    for (e in matches) {
      cnt.putIfAbsent(e[0], 0)
      cnt.merge(e[1], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val ans: List<List<Int>> = List.of(ArrayList(), ArrayList())
    for (e in cnt.entrySet()) {
      if (e.getValue() < 2) {
        ans[e.getValue()].add(e.getKey())
      }
    }
    Collections.sort(ans[0])
    Collections.sort(ans[1])
    return ans
  }
}

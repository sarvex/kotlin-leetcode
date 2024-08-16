internal class Solution {
  fun hasGroupsSizeX(deck: IntArray): Boolean {
    val cnt: Map<Int, Int> = HashMap()
    for (x in deck) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var g = cnt[deck[0]]!!
    for (x in cnt.values()) {
      g = gcd(g, x)
    }
    return g >= 2
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}

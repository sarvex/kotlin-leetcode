internal class Solution {
  private val bits = 4
  private var n = 0
  private var price: List<Int>? = null
  private var special: List<List<Int>>? = null
  private val f: Map<Int, Int> = HashMap()

  fun shoppingOffers(
    price: List<Int>?, special: List<List<Int>>?, needs: List<Int>
  ): Int {
    n = needs.size()
    this.price = price
    this.special = special
    var mask = 0
    for (i in 0 until n) {
      mask = mask or (needs[i] shl (i * bits))
    }
    return dfs(mask)
  }

  private fun dfs(cur: Int): Int {
    if (f.containsKey(cur)) {
      return f[cur]!!
    }
    var ans = 0
    for (i in 0 until n) {
      ans += price!![i] * (cur shr (i * bits) and 0xf)
    }
    for (offer in special!!) {
      var nxt = cur
      var ok = true
      for (j in 0 until n) {
        if ((cur shr (j * bits) and 0xf) < offer[j]) {
          ok = false
          break
        }
        nxt -= offer[j] shl (j * bits)
      }
      if (ok) {
        ans = Math.min(ans, offer[n] + dfs(nxt))
      }
    }
    f.put(cur, ans)
    return ans
  }
}

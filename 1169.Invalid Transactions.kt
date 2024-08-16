internal class Solution {
  fun invalidTransactions(transactions: Array<String>): List<String> {
    val d: Map<String, List<Item>> = HashMap()
    val idx: Set<Int> = HashSet()
    for (i in transactions.indices) {
      val e: Array<String> = transactions[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      val name = e[0]
      val time: Int = e[1].toInt()
      val amount: Int = e[2].toInt()
      val city = e[3]
      d.computeIfAbsent(name) { k -> ArrayList() }.add(Item(time, city, i))
      if (amount > 1000) {
        idx.add(i)
      }
      for (item in d[name]!!) {
        if (city != item.city && abs(time - item.t) <= 60) {
          idx.add(i)
          idx.add(item.i)
        }
      }
    }
    val ans: List<String> = ArrayList()
    for (i in idx) {
      ans.add(transactions[i])
    }
    return ans
  }
}

internal class Item(var t: Int, var city: String, var i: Int) 

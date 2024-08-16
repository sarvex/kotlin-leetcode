import java.util.*

internal class SummaryRanges {
  private val mp: TreeMap<Int, IntArray> = TreeMap()

  fun addNum(`val`: Int) {
    val l = mp.floorKey(`val`)
    val r = mp.ceilingKey(`val`)
    if (l != null && r != null && mp[l]!![1] + 1 === `val` && mp[r]!![0] - 1 === `val`) {
      mp[l]!![1] = mp[r]!![1]
      mp.remove(r)
    } else if (l != null && `val` <= mp[l]!![1] + 1) {
      mp[l]!![1] = Math.max(`val`, mp[l]!![1])
    } else if (r != null && `val` >= mp[r]!![0] - 1) {
      mp[r]!![0] = Math.min(`val`, mp[r]!![0])
    } else {
      mp.put(`val`, intArrayOf(`val`, `val`))
    }
  }

  val intervals: Array<IntArray>
    get() {
      val res = Array(mp.size()) { IntArray(2) }
      var i = 0
      for (range in mp.values()) {
        res[i++] = range
      }
      return res
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */

internal class RangeFreqQuery(arr: IntArray) {
  private val g: Map<Int, List<Int>> = HashMap()

  init {
    for (i in arr.indices) {
      g.computeIfAbsent(arr[i]) { k -> ArrayList() }.add(i)
    }
  }

  fun query(left: Int, right: Int, value: Int): Int {
    if (!g.containsKey(value)) {
      return 0
    }
    val idx: Unit = g[value]
    var l: Int = Collections.binarySearch(idx, left)
    l = if (l < 0) -l - 1 else l
    var r: Int = Collections.binarySearch(idx, right + 1)
    r = if (r < 0) -r - 1 else r
    return r - l
  }
}
/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */

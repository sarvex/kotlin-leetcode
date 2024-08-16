internal class SnapshotArray(length: Int) {
  private val arr: Array<List<IntArray>>
  private var idx = 0

  init {
    arr = arrayOfNulls(length)
    Arrays.setAll(arr) { k -> ArrayList() }
  }

  fun set(index: Int, `val`: Int) {
    arr[index].add(intArrayOf(idx, `val`))
  }

  fun snap(): Int {
    return idx++
  }

  fun get(index: Int, snap_id: Int): Int {
    var l = 0
    var r: Int = arr[index].size()
    while (l < r) {
      val mid = (l + r) shr 1
      if (arr[index][mid][0] > snap_id) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    --l
    return if (l < 0) 0 else arr[index][l][1]
  }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

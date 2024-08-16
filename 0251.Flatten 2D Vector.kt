internal class Vector2D(private val vec: Array<IntArray>) {
  private var i = 0
  private var j = 0

  fun next(): Int {
    forward()
    return vec[i][j++]
  }

  fun hasNext(): Boolean {
    forward()
    return i < vec.size
  }

  private fun forward() {
    while (i < vec.size && j >= vec[i].size) {
      ++i
      j = 0
    }
  }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

internal class Bitset(size: Int) {
  private var a: CharArray
  private var b: CharArray
  private var cnt = 0

  init {
    a = CharArray(size)
    b = CharArray(size)
    Arrays.fill(a, '0')
    Arrays.fill(b, '1')
  }

  fun fix(idx: Int) {
    if (a[idx] == '0') {
      a[idx] = '1'
      ++cnt
    }
    b[idx] = '0'
  }

  fun unfix(idx: Int) {
    if (a[idx] == '1') {
      a[idx] = '0'
      --cnt
    }
    b[idx] = '1'
  }

  fun flip() {
    val t = a
    a = b
    b = t
    cnt = a.size - cnt
  }

  fun all(): Boolean {
    return cnt == a.size
  }

  fun one(): Boolean {
    return cnt > 0
  }

  fun count(): Int {
    return cnt
  }

  override fun toString(): String {
    return String(a)
  }
}
/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */

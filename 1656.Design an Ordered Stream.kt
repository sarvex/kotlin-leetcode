internal class OrderedStream(n: Int) {
  private val data: Array<String>
  private var ptr: Int

  init {
    data = arrayOfNulls(n)
    ptr = 0
  }

  fun insert(idKey: Int, value: String): List<String> {
    data[idKey - 1] = value
    val ans: List<String> = ArrayList()
    while (ptr < data.size && data[ptr] != null) {
      ans.add(data[ptr++])
    }
    return ans
  }
}
/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
</String> */

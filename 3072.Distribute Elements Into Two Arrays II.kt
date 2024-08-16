import java.util.*

internal class BinaryIndexedTree(private val n: Int) {
  private val c = IntArray(n + 1)

  fun update(x: Int, delta: Int) {
    var x = x
    while (x <= n) {
      c[x] += delta
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var s = 0
    while (x > 0) {
      s += c[x]
      x -= x and -x
    }
    return s
  }
}

internal class Solution {
  fun resultArray(nums: IntArray): IntArray {
    val st = nums.clone()
    Arrays.sort(st)
    val n = st.size
    val tree1 = BinaryIndexedTree(n + 1)
    val tree2 = BinaryIndexedTree(n + 1)
    tree1.update(Arrays.binarySearch(st, nums[0]) + 1, 1)
    tree2.update(Arrays.binarySearch(st, nums[1]) + 1, 1)
    val arr1 = IntArray(n)
    val arr2 = IntArray(n)
    arr1[0] = nums[0]
    arr2[0] = nums[1]
    var i = 1
    var j = 1
    for (k in 2 until n) {
      val x = Arrays.binarySearch(st, nums[k]) + 1
      val a = i - tree1.query(x)
      val b = j - tree2.query(x)
      if (a > b) {
        arr1[i++] = nums[k]
        tree1.update(x, 1)
      } else if (a < b) {
        arr2[j++] = nums[k]
        tree2.update(x, 1)
      } else if (i <= j) {
        arr1[i++] = nums[k]
        tree1.update(x, 1)
      } else {
        arr2[j++] = nums[k]
        tree2.update(x, 1)
      }
    }
    for (k in 0 until j) {
      arr1[i++] = arr2[k]
    }
    return arr1
  }
}

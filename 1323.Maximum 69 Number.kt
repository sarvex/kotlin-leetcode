internal class Solution {
  fun maximum69Number(num: Int): Int {
    return num.toString().replaceFirst("6".toRegex(), "9").toInt()
  }
}

internal class Solution {
  fun maxDiff(num: Int): Int {
    var a = num.toString()
    var b = a
    var i = 0
    while (i < a.length) {
      if (a[i] != '9') {
        a = a.replace(a[i], '9')
        break
      }
      ++i
    }
    if (b[0] != '1') {
      b = b.replace(b[0], '1')
    } else {
      var i = 1
      while (i < b.length) {
        if (b[i] != '0' && b[i] != '1') {
          b = b.replace(b[i], '0')
          break
        }
        ++i
      }
    }
    return a.toInt() - b.toInt()
  }
}

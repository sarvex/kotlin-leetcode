internal class TextEditor {
  private val left = StringBuilder()
  private val right = StringBuilder()

  fun addText(text: String?) {
    left.append(text)
  }

  fun deleteText(k: Int): Int {
    var k = k
    k = min(k, left.length)
    left.setLength(left.length - k)
    return k
  }

  fun cursorLeft(k: Int): String {
    var k = k
    k = min(k, left.length)
    for (i in 0 until k) {
      right.append(left[left.length - 1])
      left.deleteCharAt(left.length - 1)
    }
    return left.substring(max(left.length - 10, 0))
  }

  fun cursorRight(k: Int): String {
    var k = k
    k = min(k, right.length)
    for (i in 0 until k) {
      left.append(right[right.length - 1])
      right.deleteCharAt(right.length - 1)
    }
    return left.substring(max(left.length - 10, 0))
  }
}
/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */

internal class Encrypter(keys: CharArray, values: Array<String?>, dictionary: Array<String>) {
  private val mp: Map<Char, String> = HashMap()
  private val cnt: Map<String, Int> = HashMap()

  init {
    for (i in keys.indices) {
      mp.put(keys[i], values[i])
    }
    for (w in dictionary) {
      var w = w
      w = encrypt(w)
      cnt.put(w, cnt.getOrDefault(w, 0) + 1)
    }
  }

  fun encrypt(word1: String): String {
    val sb = StringBuilder()
    for (c in word1.toCharArray()) {
      if (!mp.containsKey(c)) {
        return ""
      }
      sb.append(mp[c])
    }
    return sb.toString()
  }

  fun decrypt(word2: String): Int {
    return cnt.getOrDefault(word2, 0)
  }
}
/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */

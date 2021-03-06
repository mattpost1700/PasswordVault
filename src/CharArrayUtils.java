import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharArrayUtils {

  static void clear(char[] chars) {
    java.util.Arrays.fill(chars, '0');
  }

  static void clearList(List<char[]> charList) {
    for (char[] chars : charList) {
      java.util.Arrays.fill(chars, '0');
    }
  }

  static void clearBytes(byte[] bytes) {
    java.util.Arrays.fill(bytes, (byte) '0');
  }

  static char[] concat(char[] first, char[] second) {
    char[] result = new char[first.length + second.length];

    System.arraycopy(first, 0, result, 0, first.length);
    System.arraycopy(second, 0, result, first.length, second.length);

    return result;
  }

  static boolean listContains(List<char[]> list, char[] chars) {
    boolean same = false;
    for (char[] c : list) {
      if (Arrays.equals(chars, c)) {
        same = true;
      }
    }
    return same;
  }

  static int getIndexOf(char[] chars, char find) {
    int index = 0;
    boolean found = false;

    for (char c : chars) {
      if (c == find) {
        found = true;
        break;
      }
      index++;
    }

    if (found) {
      return index;
    } else {
      return -1;
    }
  }

  static List<char[]> spilt(char[] chars) {

    int spiltIndex = getIndexOf(chars, ' ');

    if (spiltIndex == -1) {
      System.err.println("Error: #0004");
      return null;
    }

    char[] first = new char[spiltIndex];
    int secondLength = chars.length - spiltIndex - 1;

    if (secondLength <= -1) {
      secondLength = 0;
    }

    char[] second = new char[secondLength];

    System.arraycopy(chars, 0, first, 0, spiltIndex);
    System.arraycopy(chars, spiltIndex + 1, second, 0, secondLength);

    List<char[]> spiltChars = new ArrayList<>();

    spiltChars.add(first);
    spiltChars.add(second);

    return spiltChars;
  }

  // https://stackoverflow.com/a/43996428
  static byte[] charsToBytes(char[] chars) {
    final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(chars));
    return Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());
  }

  // https://stackoverflow.com/a/43996428
  static char[] bytesToChars(byte[] bytes) {
    final CharBuffer charBuffer = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bytes));
    return Arrays.copyOf(charBuffer.array(), charBuffer.limit());
  }
}

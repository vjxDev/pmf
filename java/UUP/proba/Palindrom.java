import org.svetovid.Svetovid;

public class Palindrom {
  public static void main(String[] args) {

    String s = Svetovid.in.readLine("Unesi s");
    boolean palindrom = true;
    int n = s.length();

    for (int i = 0; (i < s.length() / 2) && palindrom; i++) {
      if (s.charAt(i) != s.charAt(n - 1 - i)) {
        palindrom = false;
      }
    }

    if (palindrom) {
      Svetovid.out.println("Palndrom");

    } else {
      Svetovid.out.println("Nije Palindrom");
    }
  }
}

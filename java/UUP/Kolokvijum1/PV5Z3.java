public class PV5Z3 {
  public static void main(String[] args) {
    String s1, s2;
    s1 = Svetovid.in.readLine("Unesite string 1");
    s2 = Svetovid.in.readLine("Unesite string 2");
    if (s1.length() != s2.length()) {
      Svetovid.out.println("Tekst nije isti");
      return;
    }
    s1 = s1.toUpperCase();
    s2 = s2.toUpperCase();
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        Svetovid.out.println("Tekst nije isti");
        return;
      }
    }
    Svetovid.out.println("Tekst je isti");
  }
}

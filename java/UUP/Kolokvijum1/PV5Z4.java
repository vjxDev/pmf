public class PV5Z4 {
  public static void main(String[] args) {
    String s1, s2;
    s1 = Svetovid.in.readLine("Unesite string 1");
    s2 = Svetovid.in.readLine("Unesite string 2");

    if (s1.length() < s2.length()) {

      String temp = s1;
      s1 = s2;
      s2 = temp;

    }
    s1 = s1.toUpperCase();
    s2 = s2.toUpperCase();
    int d1 = s1.length(), d2 = s2.length();
    for (int i = 0; i < s2.length(); i++) {

      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);

      if (c1 == c2)
        continue;
      else if (c1 > c2) {
        Svetovid.out.println(s1 + "| je vece od |" + s2);
        return;
      } else {
        Svetovid.out.println(s1 + "| je manje od |" + s2);
        return;
      }
    }

    if (d1 == d2) {
      Svetovid.out.println("Tekst je isti");
    } else if (d1 > d2) {
      Svetovid.out.println(s1 + "| je vece od |" + s2);
    } else {
      Svetovid.out.println(s1 + "| je manji od |" + s2);
    }

  }
}

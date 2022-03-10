public class TV2Zadatak1 {
  public static void main(String[] args) {
    char c;

    Svetovid.out.print("Unesite znak ");

    c = Svetovid.in.readChar("");

    while (c != '.') {
      Svetovid.out.print("  -->  ");

      if (c >= 'A' && c <= 'Z') {
        Svetovid.out.print((char) (c + 'a' - 'A'));
      } else {
        Svetovid.out.print(c);
      }

      c = Svetovid.in.readChar("");
    }
  }
}

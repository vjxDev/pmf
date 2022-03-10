public class TVZ6 {
  public static void main(String[] args) {

    int brSlovo = 0, brZnak = 0, brBroj = 0;
    char c = Svetovid.in.readChar("Unesite znak");

    while (c != '.') {
      if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
        brSlovo++;
      } else if (c >= '0' && c <= '9') {
        brBroj++;

      } else {
        brZnak++;
      }

      c = Svetovid.in.readChar("Unesite znak");
    }
    Svetovid.out.println("Slova:" + brSlovo);
    Svetovid.out.println("Broj:" + brBroj);
    Svetovid.out.println("Znak" + brZnak);
  }

}

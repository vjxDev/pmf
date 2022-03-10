public class PV4testZ2 {
  // Napisati program koji učitava sekvencu znakova dok se ne učita znak '.'
  // i ispisuje koliko među unetim znakovima ima malih slova, cifara,
  // interpunkcijskih ('.', ',', ';' , ':') i ostalih znakova.

  // mala slova
  // cifre
  // interpunkcijskih znakovi
  // ostalo
  public static void main(String[] args) {
    int brMala = 0, brCifre = 0, brInter = 0, brOstali = 0;
    char znak;
    do {
      znak = Svetovid.in.readChar("Unesite znak");

      if ('a' <= znak && znak <= 'z') {
        brMala++;
      } else if ('0' <= znak && znak <= '9') {
        brCifre++;
      } else {
        switch (znak) {
        case '.':
        case ',':
        case ';':
        case ':':
          brInter++;
          break;
        default:
          brOstali++;
          break;
        }
      }
    } while (znak != '.');
    Svetovid.out.println("Ima malih slova: " + brMala + "\nCifara: " + brCifre
        + "\nInterpunkcijskih ('.', ',', ';' , ':'): " + brInter + "\nOstali znakovi: " + brOstali);
  }
}

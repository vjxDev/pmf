public class Kolokvijum1 {
  static final String FILES_PATH = "java/f/";

  public static void main(String[] args) {
    String imeFajla = Svetovid.in.readLine("Unesite ime fajla");
    RecnaMreza mreza = new RecnaMreza(imeFajla);

    Svetovid.out.println("Unesite podatke o novoj reci");
    String i = Svetovid.in.readToken("naziv:");
    double km = Svetovid.in.readDouble("dužina u kilometrima:");
    String s = Svetovid.in.readToken("sliv kom pripada:");
    int brojDrzava = Svetovid.in.readInt("broj država kroz koje protice:");
    mreza.dodajReku(i, km, s, brojDrzava);

    Svetovid.out.println("Unesite podatke o dva sliva koja zelite da uporedite");
    String s1 = Svetovid.in.readToken("Sliv 1:");
    String s2 = Svetovid.in.readToken("Sliv 2:");

    mreza.uporediBrojRekaUSlivu(s1, s2);

    Svetovid.out.println("Podaci o rekama");
    Svetovid.out.println(mreza);

    String imeOutFajla = Svetovid.in.readLine("Unesite ime fajla za pisanje");
    mreza.stampajUFajl(imeOutFajla);
  }
}

class Reka {
  String ime;
  double km;
  String sliv;
  int brojDrzava;

  public Reka(String ime, double km, String sliv, int brojDrzava) {
    this.ime = ime;
    this.km = km;
    this.sliv = sliv;
    this.brojDrzava = brojDrzava;
  }

  public String toString() {
    return ime + " " + km + " " + sliv + " " + brojDrzava;
  }
}

class RecnaMreza {
  static final int MAKSINALNI_BROJ_REKA = 30;

  Reka[] spisakReka;
  int brojReka;

  RecnaMreza(String imeFajla) {
    spisakReka = new Reka[MAKSINALNI_BROJ_REKA];
    brojReka = 0;

    String path = Kolokvijum1.FILES_PATH + imeFajla;
    if (!Svetovid.testIn(path)) {
      Svetovid.out.println("Fajl ne postoji");
    }

    while (Svetovid.in(path).hasMore() && brojReka < MAKSINALNI_BROJ_REKA) {
      String ime = Svetovid.in(path).readToken();
      double km = Svetovid.in(path).readDouble();
      String sliv = Svetovid.in(path).readToken();
      int brojDrzava = Svetovid.in(path).readInt();
      dodajReku(ime, km, sliv, brojDrzava);
    }
    if (Svetovid.in(path).hasMore()) {
      Svetovid.out.println("Previse reka u fajlu! Ucitano prvih " + MAKSINALNI_BROJ_REKA);
    }
    Svetovid.in(path).close();

  }

  public void dodajReku(String ime, double km, String sliv, int brojDrzava) {
    if (brojReka < MAKSINALNI_BROJ_REKA) {
      spisakReka[brojReka] = new Reka(ime, km, sliv, brojDrzava);
      brojReka++;
    } else {
      Svetovid.out.println("Previse reka u nizu!");
    }
  }

  public void uporediBrojRekaUSlivu(String sliv1, String sliv2) {
    int br1 = 0, br2 = 0;
    if (sliv1.equals(sliv2)) {
      Svetovid.out.println("Uneli ste isti sliv, slivovi su iste dizine");
    }

    for (int i = 0; i < brojReka; i++) {
      if (spisakReka[i].sliv.equals(sliv1)) {
        br1++;
      }
      if (spisakReka[i].sliv.equals(sliv2)) {
        br2++;
      }
    }

    if (br2 == br1) {
      Svetovid.out.println("Broj reka je isti");
    } else if (br1 > br2) {
      Svetovid.out.println(sliv1 + " ima vise reka");
    } else {
      Svetovid.out.println(sliv2 + " ima vise reka");

    }
  }

  public void stampajUFajl(String imeOutFajla) {
    String path = Kolokvijum1.FILES_PATH + imeOutFajla;
    if (!Svetovid.testOut(path)) {
      Svetovid.out.println("Nije moguc upis u ovaj fajl");
      return;
    }
    for (int i = 0; i < brojReka; i++) {
      String s = spisakReka[i].ime + " " + spisakReka[i].km + " " + spisakReka[i].sliv + " " + spisakReka[i].brojDrzava;
      Svetovid.out(path).println(s);
    }
    Svetovid.out(path).close();
  }

  public String toString() {
    String st = "Reke [";
    if (brojReka > 0) {
      st += spisakReka[0];
    }
    for (int i = 1; i < brojReka; i++) {
      st += ", " + spisakReka[i];
    }
    st += "]";
    return st;
  }
}

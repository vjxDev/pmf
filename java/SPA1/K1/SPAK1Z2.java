public class SPAK1Z2 {
  final static int MAX_DUZINA = 50;

  static Knjige citajFajl(String path) {
    if (!Svetovid.testIn(path)) {
      Svetovid.out.println("Fajl ne postoji");
      return null;
    }
    Knjige knjige = new Knjige();
    int br = 0;
    while (Svetovid.in(path).hasMore()) {
      String naslov = Svetovid.in(path).readToken();
      String prezime = Svetovid.in(path).readToken();
      int godina = Svetovid.in(path).readInt();
      br++;
      if (br > MAX_DUZINA) {
        Svetovid.out.println("U fajlu ima vise od maksimalnog broja knjiga");
        Svetovid.in(path).close();
        return null;
      }
      knjige.dodaj(new Knjiga(naslov, prezime, godina));
      Svetovid.out.println(String.format("%s %s %s", naslov, prezime, godina));
    }
    Svetovid.in(path).close();
    return knjige;
  }

  public static void main(String[] args) {

    String path = Svetovid.in.readToken("Unesite ime fjla za knjige:");
    path = "java/f/" + path;
    Knjige knjige = citajFajl(path);
    if (knjige == null)
      return;
    knjige.korisnikDodajKnjigu();
    knjige.podaciOPiscu();
    knjige.preNekeGodine();
  }
}

class Knjige {
  Knjiga knjige[];

  int brojKnjiga = 0;

  Knjige() {
    this.knjige = new Knjiga[50];
  }

  public void korisnikDodajKnjigu() {
    String naslov = Svetovid.in.readToken("Unesite ime nove knjige");
    String prezime = Svetovid.in.readToken("Unesite prezime pisca");
    int godina = Svetovid.in.readInt("Unesite godinu izdanja");
    this.dodaj(new Knjiga(naslov, prezime, godina));
  }

  public void dodaj(Knjiga nova) {
    if (brojKnjiga > SPAK1Z2.MAX_DUZINA) {
      Svetovid.out.print("Doslite do maksimalnog broja knjiga");
      return;
    }
    this.knjige[this.brojKnjiga] = nova;
    this.brojKnjiga++;
    napraviFajl();
  }

  public void napraviFajl() {
    String path = "java/f/knjigeOut.txt";
    if (!Svetovid.testOut(path)) {
      Svetovid.out.println("fajl vec postoji");
      return;
    }
    for (int i = 0; i < brojKnjiga; i++) {
      // Knjiga ima toSting metod
      Svetovid.out(path).println(knjige[i]);
    }
    Svetovid.out(path).close();
  }

  public void podaciOPiscu() {
    String pisac = Svetovid.in.readToken("Prezime Pisca koje trazite");
    String s = "";
    for (int i = 0; i < brojKnjiga; i++) {
      if (knjige[i].pisac.equals(pisac)) {
        s += knjige[i] + "\n";
      }
    }
    if (s == "") {
      Svetovid.out.println("Nema podatka o piscu");
    } else {
      Svetovid.out.println(s);
    }
  }

  public void preNekeGodine() {
    int god = Svetovid.in.readInt("Prebrojati koliko knjiga je izdato pre unete godine, unesite godinu");
    int br = 0;
    for (int i = 0; i < brojKnjiga; i++) {
      if (knjige[i].godina < god) {
        br++;
      }
    }
    Svetovid.out.println("Broj knjiga pre unete godine je:" + br);
  }
}

class Knjiga {
  String naslov, pisac;
  int godina;

  public Knjiga(String nslov, String pisac, int godina) {
    this.naslov = nslov;
    this.pisac = pisac;
    this.godina = godina;
  }

  public String toString() {
    return String.format("%s %s %s", naslov, pisac, godina);
  }
}
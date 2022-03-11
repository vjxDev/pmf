
public class SPAK1Z1 {

  public static void kreirajFajl(String f) {
    Svetovid.out(f).println("Prvi red");
    Svetovid.out(f).println("Drugi red");
    Svetovid.out(f).println("");
    Svetovid.out(f).println("Cetvri red");
    Svetovid.out(f).close();

  }

  public static void napisiNaEkran(String f) {
    if (!Svetovid.testIn(f))
      return;
    while (Svetovid.in(f).hasMore()) {
      String line = Svetovid.in(f).readLine();
      Svetovid.out.println(line);
    }
    Svetovid.in(f).close();

  }

  public static void izracinajSumu(String f) {
    if (!Svetovid.testIn(f))
      return;
    double sum = 0;
    int br = 0;
    while (Svetovid.in(f).hasMore()) {
      Double num = Svetovid.in(f).readDouble();
      sum += num;
      br++;
    }
    if (br != 0) {
      Svetovid.out.println(sum / br);
    } else {
      Svetovid.out.println("Nije moguce delieti nulom");
    }
    Svetovid.in(f).close();
    Svetovid.out.println(sum);
  }

  public static void pronadjniIme(String f, String ime) {
    if (!Svetovid.testIn(f)) {
      Svetovid.out.println("fajl ne postoji");
      return;
    }
    boolean nadjeno = false;
    while (Svetovid.in(f).hasMore() && !nadjeno) {
      String imeIzF = Svetovid.in(f).readLine();
      if (imeIzF.equalsIgnoreCase(ime)) {
        nadjeno = true;
      }
    }
    Svetovid.in(f).close();

    if (nadjeno) {
      Svetovid.out.println("Ime je nadjeno");
    } else {
      Svetovid.append(f).println(ime);
      Svetovid.in(f).close();
      Svetovid.out.println("Ime nije nadjeno");
    }

  }

  public static void main(String[] args) {
    kreirajFajl("f/fajl1.txt");
    napisiNaEkran("f/fajl1.txt");
    izracinajSumu("f/brojevi.txt");
    String ime = Svetovid.in.readLine("Ukucajte ime koje zelite da pronadjte:");
    pronadjniIme("f/imena.txt", ime);
  }
}

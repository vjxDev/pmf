public class PV10Z1test {
  public static void main(String[] args) {

    Svetovid.out.println("Unesite polinom p:");
    Polinom p = PolinomN.ucitaj();
    Svetovid.out.println("Unesite polinom q:");
    Polinom q = PolinomN.ucitaj();
    Polinom[] niz = PolinomN.deli(p, q);

    for (int i = 0; i < niz.length; i++) {
      System.out.println();
      Svetovid.out.print("p(x)q(x) = ");
      PolinomN.stampaj(niz[i]);
    }

    // Polinom r = new Polinom();
    // r.st = 5;
    // r.k[5] = -2.0;
    // r.k[1] = 3.0;

    // Polinom qq = PolinomN.puta(q, q);
    // if (qq != null) {
    // double qOd5 = PolinomN.izracunaj(5, q);
    // Polinom p3 = PolinomN.brojPuta(p, 3);

    // r.k[0] = -qOd5;

    // r = PolinomN.saberi(r, qq);
    // r = PolinomN.oduzmi(r, p3);

    // System.out.println();
    // System.out.print("r(x) = ");
    // PolinomN.stampaj(r);

    // int minIndex = 0;

    // for (int i = 0; i <= r.st; i++) {
    // if (r.k[i] != 0.0) {
    // r.k[i] += 7.0;
    // }
    // }
    // for (int i = 0; i <= r.st; i++) {
    // if (r.k[i] < r.k[minIndex])
    // minIndex = i;
    // }

    // Polinom monom = new Polinom();
    // monom.st = minIndex;
    // monom.k[minIndex] = r.k[minIndex];

    // System.out.println();
    // System.out.print("Monom sa najmanjim koeficijentom = ");
    // PolinomN.stampaj(monom);

    // } else {
    // Svetovid.out.println("Poliom r i q^2 je prevelikog stepena.");
    // }

  }
}

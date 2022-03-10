/* Program koji racuna vrednost x^n za dati realan broj x
   i prirodan broj n. */
   
class Stepen {
  public static void main(String[] args) {
    double x, rez;
    int n, i;

    // ucitavanje realnog broja u promenljivu x
    System.out.print("Unesite realan broj x: ");
    x = Svetovid.in.readDouble();

    // ucitavanje celog broja u promenljivu n
    System.out.print("Unesite prirodan broj n: ");
    n = Svetovid.in.readInt();

    // izracunavanje rezultata u promenljivoj rez
    rez = 1.0;
    for (i = 0; i < n; i++) {
      rez = rez * x;
    }

    // stampanje ucitanih brojeva i rezultata
    System.out.println(x + "^" + n + " = " + rez);
  }
}
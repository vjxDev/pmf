/* Program koji izracunava vrednost izraza (sume)
   1/1 + 1/2 + ... + 1/n za dati prirodan broj n. */

class Suma {
  public static void main(String[] args) {
    int n, i;
    double rez;
  
    // unos prirodnog broja n
    System.out.print("Unesite prirodan broj n: ");
    n = Svetovid.in.readInt();

    // izracunavanje sume
    rez = 0.0;
    for(i = 1; i <= n; i++) {
      rez = rez + 1.0 / i;
    }

    // ispis rezultata
    System.out.println("Suma 1/i, i = 1..." + n + " je " + rez);
  }
}
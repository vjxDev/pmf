/* Program koji racuna obim i povrsinu kruga datog poluprecnika. */

class Krug {
  public static void main(String[] args) {
    double poluprecnik, povrsina, obim;

    // unos poluprecnika u promenljivu poluprecnik
    System.out.print("Unesite poluprecnik kruga: ");
    poluprecnik = Svetovid.in.readDouble();

    // izracunavanje povrsine i obima
    povrsina = poluprecnik * poluprecnik * Math.PI;
    obim = 2.0 * poluprecnik * Math.PI;

    // stampanje rezultata
    System.out.print("Povrsina kruga sa unetim poluprecnikom je ");
    System.out.println(povrsina + ", a njegov obim je " + obim);
  }
}
/* Program koji racuna vrednost funkcije
          {   x^2, x < 0
   f(x) = {    42, x = 0
          { ln(x), x > 0
 */
class Funkcija {
  public static void main(String[] args) {
    double x, rez;
   
    // unos argumenta funkcije
    System.out.print("Unesite vrednost argumenta funkcije: ");
    x = Svetovid.in.readDouble();
   
    // izracunavanje
    if (x < 0) {
      rez = x * x;
    } 
    else if (x == 0) {
      rez = 42;
    }
    else {
      rez = Math.log(x);
    }
    
    // ispis rezultata
    System.out.println("Za vrednost argumenta " + x +
                       " vrednost funkcije iznosi " + rez);
  }
}
/* Program koji ucitava dva broja, znak za operaciju (+: sabiranje,
   *: mnozenje, /: deljenje), primenjuje datu operaciju na ucitane
   brojeve i ispisuje rezultat izracunavanja. */
   
class Operacija {
  public static void main(String[] args) {
    double broj1, broj2, rezultat;
    char op;
    
    // unos operanada i operacije
    System.out.print("Unesite prvi broj: ");
    broj1 = Svetovid.in.readDouble();
    System.out.print("Unesite drugi broj: ");
    broj2 = Svetovid.in.readDouble();
    System.out.print("Unesite znak za operaciju (+, *, /): ");
    op = Svetovid.in.readChar();
 
    // izracunavanje i ispis rezultata
    if ((op == '+') || (op == '*') || (op == '/')) {
      if (op == '+') {
        rezultat = broj1 + broj2;
      }
      else if (op == '*') { 
        rezultat = broj1 * broj2;
      } 
      else {
        if (broj2 != 0) {
          rezultat = broj1 / broj2;
        }
        else {
          rezultat = 0;
        }
      }
      System.out.println("Rezultat je: " + rezultat);
    }
    else {
      System.out.println("Operacija nije dobro zadata.");
    } 
  }
}
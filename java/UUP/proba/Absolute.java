/* Program koji racuna apsolutnu vrednost unetog celog broja. */

class Absolute {
  public static void main(String[] args) {
    int x, abs;

    // unos broja u promenljivu x
    System.out.print("Unesite ceo broj: ");
    x = Svetovid.in.readInt();
    
    // izracunavanje apsolutne vrednosti broja
    abs = x;
    if (x < 0) {
      abs = -x;   
    }
    
    // stampanje rezultata
    System.out.println("Apsolutna vrednost broja je: " + abs);
  }
}
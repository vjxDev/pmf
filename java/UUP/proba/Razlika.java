/* Program koji racuna razliku dva ucitana cela broja. */

class Razlika {
  public static void main(String[] args) {
    int prvi, drugi, razlika;

    // ucitavanje prvog broja u promenljivu prvi
    System.out.print("Unesite prvi ceo broj: ");
    prvi = Svetovid.in.readInt();
  
    // ucitavanje drugog broja u promenljivu drugi
    System.out.print("Unesite drugi ceo broj: ");
    drugi = Svetovid.in.readInt();

    // izracunavanje razlike brojeva i smestanje rezultata u promenljivu razlika 
    razlika = prvi - drugi;
  
    // stampanje ucitanih brojeva i rezultata
    System.out.println(prvi + " - " + drugi + " = " + razlika);
  }  
}
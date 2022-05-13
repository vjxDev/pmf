public class SPAK2S1 {
  public static void main(String[] args) {

  }
}

// Lista Opstina
// Gradjane
//

class People {
  People succ;
  String name;

  public People(String name) {
    this.name = name;
  }
}

class Car {
  People first;
  Car succ;

  String model;

  public Car(String model) {

  }

}

class SPAK2S1_Opstina {
  Car first;

}
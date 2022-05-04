
public class SPAK2Z5Test {
  public static void main(String[] args) {
    GameRoom gRoom = new GameRoom();
    Svetovid.out.println(
        gRoom.addBox("Plava", "123"));
    gRoom.addBox("Zuta", "456");
    gRoom.addBox("Zuta", "777");
    Svetovid.out.println(gRoom.addBox("Plava", "123")); // Provera da li je vec dodata
    Svetovid.out.println(gRoom);

    gRoom.addToyToBox("123", "Plastika", "Kocka");

    gRoom.addToyToBox("123", "B4Plastika", "Kocka");
    gRoom.addToyToBox("123", "B1Plastika", "Kocka");
    gRoom.addToyToBox("123", "Plastika", "Kocka");
    gRoom.addToyToBox("123", "B3Plastika", "Kocka");
    gRoom.addToyToBox("123", "APlastika", "Kocka");

    gRoom.addToyToBox("123", "Drvi", "Opis2");
    gRoom.addToyToBox("123", "Plastika", "Opis3");
    gRoom.addToyToBox("456", "Plastika", "Opis4");
    gRoom.addToyToBox("456", "Plastika", "Opis4");
    gRoom.addToyToBox("456", "Plastika", "Opis4");
    gRoom.addToyToBox("456", "Plastika", "Opis4");
    gRoom.addToyToBox("456", "Plastika", "Opis4");
    gRoom.addToyToBox("456", "Drvo", "Opis4");
    gRoom.addToyToBox("456", "Drvo", "Opis4");
    gRoom.addToyToBox("456", "Drvo", "Opis4");

    Svetovid.out.println(gRoom);

    Svetovid.out.println("------------");
    Box b = gRoom.boxWithTheMostOfType("Plastika");
    Svetovid.out.println("Kutija sa najvise igracka tipa Plastika" + b);
    Svetovid.out.println("------------");
    gRoom.deleteBox("123");
    Svetovid.out.println(gRoom);
  }
}

class ToyNode {
  String type;
  String description;
  ToyNode succ;

  ToyNode(String type, String description) {
    this.description = description;
    this.type = type;
    succ = null;
  }

  public String toString() {
    return "Igracka [tip=" + type + ", opis=" + description + "]";
  }
}

class Box {

  ToyNode first;
  Box succ;

  String color;
  String id;

  public Box(String color, String id) {
    this.color = color;
    this.id = id;
    this.first = null;
    succ = null;
  }

  // add a toy so its sorted by type
  // there can be multple toys with the same type
  public boolean addToy(String type, String description) {
    ToyNode current, prev;
    current = first;
    prev = null;
    while (current != null && current.type.compareTo(type) < 0) {
      prev = current;
      current = current.succ;
    }
    if (current != null && current.type.equals(type)) {
      return false;
    } else {
      ToyNode node = new ToyNode(type, description);
      if (prev == null) {
        node.succ = first;
        first = node;
      } else {
        node.succ = prev.succ;
        prev.succ = node;
      }
      return true;
    }
  }

  public int getNumberOfToysOfType(String type) {
    int count = 0;
    ToyNode current = first;
    while (current != null) {
      if (current.type.equals(type)) {
        count++;
      }
      current = current.succ;
    }
    return count;
  }

  public String toString() {
    String s = "Box [id=" + id + ", color=" + color + ", toys=";
    ToyNode el = first;

    if (el != null) {
      s += el;
      el = el.succ;
      while (el != null) {
        s += ", " + el;
        el = el.succ;
      }
    }
    return s + " ]";
  }

}

class GameRoom {
  Box first;

  public GameRoom() {
    first = null;
  }

  public Box findBox(String id) {
    Box current = first;
    while (current != null) {
      if (current.id.equals(id))
        return current;
      current = current.succ;
    }
    return null;
  }

  public boolean boxExists(String id) {
    return findBox(id) != null;
  }

  public boolean addBox(String color, String id) {
    if (boxExists(id))
      return false;
    Box newBox = new Box(color, id);
    newBox.succ = first;
    first = newBox;
    return true;
  }

  public boolean addToyToBox(String boxId, String toyType, String toyDescription) {
    Box box = findBox(boxId);
    if (box == null)
      return false;
    box.addToy(toyType, toyDescription);
    return true;
  }

  public Box boxWithTheMostOfType(String type) {
    String s;
    Box max = first;
    Box current = first;
    while (current != null) {
      if (current.getNumberOfToysOfType(type) > max.getNumberOfToysOfType(type))
        max = current;

      current = current.succ;
    }
    return max;
  }

  public boolean deleteBox(String id) {
    Box current = first;
    Box prev = null;
    while (current != null) {
      if (current.id.equals(id)) {
        if (prev == null) {
          first = current.succ;
        } else {
          prev.succ = current.succ;
        }
        return true;
      }
      prev = current;
      current = current.succ;
    }
    return false;
  }

  public String toString() {
    String s = "Game room: [";
    Box el = first;

    if (el != null) {
      s += el;
      el = el.succ;
      while (el != null) {
        s += ", " + el;
        el = el.succ;
      }
    }
    return s + "]";
  }

}
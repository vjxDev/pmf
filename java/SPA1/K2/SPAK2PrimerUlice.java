public class SPAK2PrimerUlice {
  public static void main(String[] args) {
    SPAK2PrimerUlice_Ulica ulica = new SPAK2PrimerUlice_Ulica();
    ulica.addHome(4);
    ulica.addHome(7);
    ulica.addHome(4);
    ulica.addHome(9);
    ulica.addHome(1);
    ulica.addHome(99);
    ulica.addHome(4);
    ulica.addHome(1);
    ulica.addHome(7);
    ulica.addHome(77);
    ulica.addHome(4);
    ulica.addHome(99);

    Svetovid.out.println(ulica);

    ulica.addPerson(77, "Nikola");
    ulica.addPerson(9, "Nenad");
    ulica.addPerson(9, "Jasmina");
    ulica.addPerson(9, "Andjelija");
    ulica.addPerson(9, "Nikola");
    ulica.addPerson(9, "Nikola");
    ulica.addPerson(7, "Nikola");
    ulica.addPerson(99, "Mmmmmmm");
    ulica.addPerson(99, "Nikola");
    ulica.addPerson(99, "Nikola");
    ulica.addPerson(99, "Nikola");
    ulica.addPerson(80, "Nikola");
    ulica.addPerson(80, "Nikola");

    Svetovid.out.println(ulica);

    Svetovid.out.println("ID kuca sa najvise ljudi duzine" + ulica.findHomeWithNames(5));

    ulica.movePerson(99, 4);
    Svetovid.out.println(ulica);
    Svetovid.out.println(ulica.findHome(9).removeLast());
    Svetovid.out.println(ulica);

  }

}

// Ulica
// Kuca
// Osoba

class SPAK2PrimerUlice_Ulica {
  Home first;

  public Home findHome(int id) {
    Home el = first;
    while (el != null) {
      if (el.id == id)
        return el;
      el = el.succ;
    }
    return null;
  }

  public boolean homeExists(int id) {
    if (findHome(id) == null)
      return false;

    return true;
  }

  public boolean addHome(int id) {

    Home newHome = new Home(id);

    if (first == null || first.id > id) {
      newHome.succ = first;
      first = newHome;
      return true;
    } else {
      if (first.id != id) {
        Home curr = first;
        while (curr.succ != null && curr.succ.id < id) {
          curr = curr.succ;
        }
        if (curr.succ == null || curr.succ.id != id) {
          newHome.succ = curr.succ;
          curr.succ = newHome;
          return true;
        }
      }
    }
    return false;
  }

  public boolean addPerson(int id, String name) {
    Home home = findHome(id);
    if (home == null)
      return false;
    home.addPerson(name);
    return true;
  }

  public int findHomeWithNames(int nameLen) {
    if (first == null) {
      return 0;
    }
    Home max = first;
    Home curr = first;
    int maxLen = max.numberOfPeopeWithLongNames(nameLen);
    while (curr != null) {
      int currLen = curr.numberOfPeopeWithLongNames(nameLen);
      if (currLen > maxLen) {
        max = curr;
        maxLen = currLen;
      }
      curr = curr.succ;
    }
    return max.id;
  }

  public boolean removeHome(int id) {

    if (first == null) {
      return false;
    }
    if (first.id == id) {
      first = first.succ;
    }

    Home curr = first;
    while (curr.succ != null) {
      if (curr.succ.id == id) {
        curr.succ = curr.succ.succ;
        return true;
      }
      curr = curr.succ;
    }

    return false;

  }

  public boolean movePerson(int fromID, int toID) {
    Home from = findHome(fromID);
    Home to = findHome(toID);

    if (from == null) {
      return false;
    }

    Person lastPrsonFrom = from.removeLast();

    if (lastPrsonFrom == null) {
      return false;
    } else {
      if (to == null) {
        return true;
      }
      to.movePerson(lastPrsonFrom);
      return true;
    }
  }

  public String toString() {
    String s = "Streat List[ ";
    Home curr = first;
    if (curr != null) {
      s += curr;
      curr = curr.succ;
      while (curr != null) {
        s += ", " + curr;
        curr = curr.succ;
      }
    }
    return s + "]";
  }

  class Home {
    Home succ;
    int id;
    Person first;

    public Home(int id) {
      this.id = id;
    }

    public void addPerson(String name) {
      Person newNode = new Person(name);
      newNode.succ = first;
      first = newNode;
    }

    public void movePerson(Person newNode) {
      newNode.succ = first;
      first = newNode;
    }

    public Person removeLast() {
      if (first == null) {
        return null;
      }
      Person last = first;
      Person curr = first;
      if (first.succ == null) {
        first = null;
        return last;
      }

      while (curr.succ.succ != null) {
        curr = curr.succ;
      }
      last = curr.succ;
      curr.succ = null;

      return last;
    }

    public int numberOfPeopeWithLongNames(int nameLen) {
      int conut = 0;
      Person curr = first;
      while (curr != null) {
        if (curr.name.length() >= nameLen)
          conut++;
        curr = curr.succ;
      }
      return conut;
    }

    public String toString() {
      String s = "Home(" + id + ") [";
      Person curr = first;

      if (curr != null) {
        s += curr;
        curr = curr.succ;
        while (curr != null) {
          s += ", " + curr;
          curr = curr.succ;
        }
      }

      return s + "]";
    }
  }

  class Person {
    Person succ;
    String name;

    public Person(String name) {
      this.name = name;
    }

    public String toString() {
      return name;
    }
  }
}
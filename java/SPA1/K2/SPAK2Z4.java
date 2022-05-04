
public class SPAK2Z4 {
  public static void main(String[] args) {
    SpisakFilmova_SPAK2Z4 spisak = new SpisakFilmova_SPAK2Z4();

    spisak.addFilm("Lepa brena");
    spisak.addFilm("Zikina dinastija");
    spisak.addFilm("Test 1");

    spisak.addActorToFilm("proba 1", "Test 1");
    Svetovid.out.println(spisak.addActorToFilm("proba 2", "Zikina dinastija"));
    Svetovid.out.println(spisak.addActorToFilm("proba 2", "Zikina dinastija"));
    spisak.addActorToFilm("proba 3", "Lepa brena");
    spisak.addActorToFilm("proba 3", "Zikina dinastija");

    Svetovid.out.println(spisak);

    spisak.deliteFilmsWithActor("proba 3");

    Svetovid.out.println(spisak);
  }
}

class SpisakFilmova_SPAK2Z4 {
  Film first = null;

  public Film findFilm(String filmName) {
    Film el = first;
    while (el != null) {
      if (el.filmName.equals(filmName))
        return el;
      el = el.succ;
    }
    return null;
  }

  public boolean filmExists(String filmName) {
    return findFilm(filmName) != null;
  }

  public boolean addFilm(String filmName) {
    if (filmExists(filmName))
      return false;
    Film node = new Film(filmName);
    node.succ = first;
    first = node;
    return true;
  }

  public boolean addActorToFilm(String actorName, String filmName) {
    Film f = findFilm(filmName);
    if (f == null)
      return false;

    return f.actors.addActor(actorName);
  }

  public int deliteFilmsWithActor(String actorName) {
    int br = 0;

    Film el = first;
    while (el != null) {
      if (el.actors.deleteActor(actorName))
        br++;
      el = el.succ;
    }
    return br;
  }

  class Film {
    Film succ;
    String filmName;
    ActorList actors;

    public Film(String filmName) {
      this.filmName = filmName;
      actors = new ActorList();
    }
  }

  public String toString() {
    String s = "Filmovi [";
    Film el = first;

    if (el != null) {
      s += el.filmName + ": " + el.actors;
      el = el.succ;
      while (el != null) {
        s += ", " + el.filmName + ": " + el.actors;
        el = el.succ;
      }
    }
    return s + "]";
  }

  class ActorList {
    Actor first;

    public Actor findActor(String filmName) {
      Actor el = first;
      while (el != null) {
        if (el.value.equals(filmName))
          return el;
        el = el.succ;
      }
      return null;
    }

    public boolean actorExists(String actorName) {
      return findActor(actorName) != null;
    }

    public boolean addActor(String actorName) {
      if (actorExists(actorName))
        return false;
      Actor node = new Actor(actorName);
      node.succ = first;
      first = node;
      return true;
    }

    public boolean deleteActor(String actorName) {

      if (first != null && first.value.equals(actorName)) {
        first = first.succ;
        return true;
      } else {
        Actor current, prev;
        current = first;
        prev = null;
        while (current != null && !current.value.equals(actorName)) {
          prev = current;
          current = current.succ;
        }
        if (current != null) {
          prev.succ = current.succ;
          return true;
        } else {
          return false;
        }
      }

    }

    public String toString() {
      String s = "Glumci [ ";
      Actor el = first;

      if (el != null) {
        s += el.value;
        el = el.succ;
        while (el != null) {
          s += ", " + el.value;
          el = el.succ;
        }
      }
      return s + " ]";
    }

    class Actor {
      String value;
      Actor succ;

      public Actor(String ime) {
        this.value = ime;
        this.succ = null;
      }

      public String toString() {
        return value;
      }
    }
  }

}

// create a linked list of pornstars

class LinkedList {
  private Node first;

  public LinkedList() {
    first = null;
  }

  public boolean add(String value) {
    Node node = new Node(value);
    node.succ = first;
    first = node;
    return true;
  }

  public boolean delete(String value) {
    Node current, prev;
    current = first;
    prev = null;
    while (current != null && !current.value.equals(value)) {
      prev = current;
      current = current.succ;
    }
    if (current != null) {
      prev.succ = current.succ;
      return true;
    } else {
      return false;
    }
  }

  public boolean exists(String value) {
    Node current = first;
    while (current != null) {
      if (current.value.equals(value))
        return true;
      current = current.succ;
    }
    return false;
  }

  public String toString() {
    String s = "Pornstars [ ";
    Node el = first;

    if (el != null) {
      s += el.value;
      el = el.succ;
      while (el != null) {
        s += ", " + el.value;
        el = el.succ;
      }
    }
    return s + " ]";
  }

  class Node {
    String value;
    Node succ;

    public Node(String value) {
      this.value = value;
      this.succ = null;
    }

    public String toString() {
      return value;
    }
  }
}

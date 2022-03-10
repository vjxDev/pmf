
public class Znak {
	public static void main(String[] args) {
		char znak;
		znak = Svetovid.in.readChar("Unesite znak");
		if ((znak >= 'A' && znak <= 'Z') || (znak >= 'a' && znak <= 'z')) {
			Svetovid.out.println("Znak je slovo");
		} else if (znak >= '0' && znak <= '9') {
			Svetovid.out.println("Znak je broj");
		} else {
			Svetovid.out.println("Znak je specijalan znak");
		}
	}
}

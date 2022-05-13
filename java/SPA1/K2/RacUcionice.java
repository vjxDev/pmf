class RacUcionice {
	public static void main(String[] args) {
		Svetovid.out.println("3".compareTo("1"));
		ListaUcionica lista = new ListaUcionica(); 
		lista.addUcionica("Plava"); lista.addUcionica("Zuta"); 
		lista.addUcionica("Zelena"); lista.addUcionica("Plava"); 
		Svetovid.out.println(lista); 
		Svetovid.out.println(lista.findUcionica(0)); 
		Svetovid.out.println(lista.findUcionica(2)); 
		Svetovid.out.println(lista.findUcionica(9)); 
		lista.addOprema(1,"N987ike patike","stvarne patike"); 
		lista.addOprema(1,"N29ike patike","stvarne patike"); 
		lista.addOprema(1,"N7ike patike","stvarne patike"); 
		lista.addOprema(1,"N83ike patike","stvarne patike"); 
		lista.addOprema(1,"N9ike patike","stvarne patike"); 
		lista.addOprema(1,"N03ike patike","stvarne patike"); 
		lista.addOprema(1,"Nike patike","stvarne patike"); 
		lista.addOprema(1,"Nike patike","stvarne patike"); 
		lista.addOprema(2,"Nike patike","stvarne patike"); 
		lista.addOprema(9,"Nike patike","stvarne patike"); 
		Svetovid.out.println(lista); 
		lista.addOpremaNta("Plava",2,"Test1","Test 1"); 
		lista.addOpremaNta("Plava",1,"Test2","Test 2"); 
		lista.addOpremaNta("Plava",6,"Test3","Test 3"); 
		Svetovid.out.println(lista); 
		Svetovid.out.println("---------"); 
		Svetovid.out.println(lista.findUcionica(1));
	}
}


class ListaUcionica{
	Ucionica first;


	public void addUcionica(String boja) {
		Ucionica u = new Ucionica(boja);

		Ucionica curr = first;
		if(first == null) {
			first = u;
			return;
		}
		while(curr.succ!=null) {
				curr = curr.succ;
		}
		curr.succ = u;
	}

	public Ucionica findUcionica(int id) {
		if(id < 1) {
				return null;
		}
		Ucionica curr = first;
		int br = 1;
		while(curr != null) {
			if(br == id) {
					return curr;
			}
			curr = curr.succ;
			br++;
		}
		return null;
	}

	public boolean addOprema(int id,String tip,String opis) {
		Ucionica u = findUcionica(id);
		if(u == null) {
			return false;
		}
		u.dodajOpremu(tip,opis);
		return true;
	}

	public boolean addOpremaNta(String boja,int nta,String tip,String opis) {
		Ucionica curr = first;
		int br = 1;
		if(first == null || nta < 1) {
			return false;
		}

		while(curr != null) {
			if(curr.boja.equals(boja)) {
				if(br == nta) {
					curr.dodajOpremu(tip,opis);
					return true;
				}
				br++;
			}
			curr = curr.succ;
		}

		return false;
	}



	public String toString() {
		String out = "Racunarkse Ucionice [";
		Ucionica curr = first;
		if(curr != null) {
			out+= curr;
			curr = curr.succ;
			while(curr != null) {
				out+= ", "+ curr;
				curr = curr.succ;
			}
		}
		return out +" ]";
	}

}

class Ucionica{
	Ucionica succ;
	Oprema first;

	String boja;

	public Ucionica(String boja) {
		this.boja = boja;
	}
	public void dodajOpremu(String tip,String opis) {


		if(first == null || first.tip.compareTo(tip) >= 0 ) {
			Oprema o = new Oprema(tip,opis);
			o.succ = first;
			first = o;
		} else {
			Oprema curr = first;

				while(curr.succ != null && curr.succ.tip.compareTo(tip) < 0) {
						curr = curr.succ;
				}
				Oprema oprema = new Oprema(tip,opis);
				oprema.succ = curr.succ;
				curr.succ = oprema;
		}

	}

	public String toString() {
		String out = "Ucionica("+boja+") [";
		Oprema curr = first;
		if(curr != null) {
			out+= curr;
			curr = curr.succ;
			while(curr != null) {
				out+= ", "+ curr;
				curr = curr.succ;
			}
		}
		return out +" ]";
	}
}

class Oprema {
	Oprema succ;

	String tip;
	String opis;

	public Oprema(String tip,String opis) {
	this.tip = tip;
	this.opis = opis;
	}

	public String toString() {
			return "Oprema: tip("+tip+")";// opis("+opis+")";
	}
}

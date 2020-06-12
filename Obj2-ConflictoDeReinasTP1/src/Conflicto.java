import java.util.Comparator;

public class Conflicto implements Comparator<Conflicto>{
	private Reina conflictiva1;
	private Reina conflictiva2;
	
	
	public Conflicto(Reina r1, Reina r2) {
		this.setConflictiva1(r1);
		this.setConflictiva2(r2);

	}
	
	public Conflicto() {
		this(null,null);
	}
	
	public int compare(Conflicto o1, Conflicto o2) {//ordena la lista de conflictos de cada reina dependiendo el numero de reina
		int i=0;
		if(o1.getConflictiva2().getnReina()<o2.getConflictiva2().getnReina()) i=-1;
		if(o1.getConflictiva2().getnReina()==o2.getConflictiva2().getnReina()) i=0;
		if(o1.getConflictiva2().getnReina()>o2.getConflictiva2().getnReina()) i=1;
		return i;
	}
	
	public String toString() {
		return "Reina 1:"+this.getConflictiva1()+"; \nReina 2: "+this.getConflictiva2()+";\n\n";
	}
	
	public boolean equals(Conflicto c) {
		if(this.getConflictiva1().equals(c.getConflictiva1()) || this.getConflictiva1().equals(c.getConflictiva2()) && this.getConflictiva2().equals(c.getConflictiva1()) || this.getConflictiva2().equals(c.getConflictiva2())) return true;
		else return false;
	}
	
	public Reina getConflictiva1() {
		return conflictiva1;
	}
	public void setConflictiva1(Reina conflictiva1) {
		this.conflictiva1 = conflictiva1;
	}
	public Reina getConflictiva2() {
		return conflictiva2;
	}
	public void setConflictiva2(Reina conflictiva2) {
		this.conflictiva2 = conflictiva2;
	}
}

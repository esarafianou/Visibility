

public class Building {

	
	private int xsw;
	private int ysw;
	private int xne;
	private int yne;
	private float h;
	private int Xchosen;
	private int ishidden;
	
	
	public Building(int xsw, int ysw, int xne, int yne, float h) {
		super();
		this.xsw = xsw;
		this.ysw = ysw;
		this.xne = xne;
		this.yne = yne;
		this.h = h;
		this.Xchosen=0;
		this.ishidden=-1;
	}


	public int getXchosen() {
		return Xchosen;
	}


	public void setXchosen(int xchosen) {
		Xchosen = xchosen;
	}


	public int getIshidden() {
		return ishidden;
	}


	public void setIshidden(int ishidden) {
		this.ishidden = ishidden;
	}


	public int getXsw() {
		return xsw;
	}


	public void setXsw(int xsw) {
		this.xsw = xsw;
	}


	public int getYsw() {
		return ysw;
	}


	public void setYsw(int ysw) {
		this.ysw = ysw;
	}


	public int getXne() {
		return xne;
	}


	public void setXne(int xne) {
		this.xne = xne;
	}


	public int getYne() {
		return yne;
	}


	public void setYne(int yne) {
		this.yne = yne;
	}


	public float getH() {
		return h;
	}


	public void setH(float h) {
		this.h = h;
	}
	
	
	

	public int hides(Building b){
		if ((this.getH()>=b.getH()) && (this.getYne()<=b.getYsw() && (this.getXsw()<=b.getXsw()) && this.getXne()>=b.getXne()))
			return 0;
		else 
			return -1;
		
	}
	
	public int ishiddenbypart(Building b) {
		if ((this.getH()>=b.getH()) && (this.getYne()<=b.getYsw()))
			return 0;
		else 
			return -1;
	}
	
	
	
	
	
	
	/* compares two buildings. first compare x and then y */
	public static int compare (Building a, Building b) {
		if (a.getXsw() < b.getXsw()) {
			return -1;
		}
		else if (a.getXsw() > b.getXsw()) {
			return 1;
		}
		if (a.getYsw() < b.getYsw()) {
			return -1;
		}
		else if (a.getYsw() > b.getYsw()) {
			return 1;
		}
		if (a.getXne() < b.getXne()) {
			return -1;
		}
		else if (a.getXne() > b.getXne()) {
			return 1;
		}
		if (a.getYne() < b.getYne()) {
			return -1;
		}
		else if (a.getYne() > b.getYne()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public String  toString () {
		return Integer.toString(this.Xchosen);
	}
}

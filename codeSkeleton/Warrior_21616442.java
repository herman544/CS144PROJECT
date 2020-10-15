public class Warrior_21616442 {
	
	private int row, col, id; 
	private String wtype, movements;
	private int age,  OP,  DS,  IS;
	private double health;
	
	
	@Override
	public String toString() {
		return id+", "+age+", "+health+", "+OP+", "+DS+", "+0+", "+wtype+", "+row+", "+col;
	}

	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getWtype() {
		return wtype;
	}
	
	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	public String getMovements() {
		return movements;
	}
	
	public void setMovements(String movements) {
		this.movements = movements;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getOP() {
		return OP;
	}
	
	public void setOP(int oP) {
		OP = oP;
	}
	
	public int getDS() {
		return DS;
	}
	
	public void setDS(int dS) {
		DS = dS;
	}
	
	public int getIS() {
		return IS;
	}
	
	public void setIS(int iS) {
		IS = iS;
	}
	
	public double getHealth() {
		return health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	
	

}


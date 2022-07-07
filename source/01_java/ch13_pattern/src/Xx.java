
public class Xx {
	private int i;
	private int j;
	public Xx(int i, int j) {
		this.i = i;
		this.j = j;
	}
	@Override
	public String toString() {
		return "Xx [i=" + i + ", j=" + j + "]";
	}
	public String infoString() {
		return "i="+i+", j="+j;
	}
	public void print() {
		System.out.println("i="+i+", j="+j);
	}
}

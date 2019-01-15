package de3d;
public class Point {
	private float x;
	private float y;
	private float z;

	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float[] getCoord() {
		float tab[]={this.x,this.y,this.z};
		return tab;

	}
	
	public boolean equals(Point p) {
		if (p.getAbscisse() == this.getAbscisse() && p.getOrdonnee() == this.getOrdonnee() && p.getProfondeur() == this.getProfondeur()) return true;
		return false;
	}

	public float getAbscisse() {
		return this.x;
	}

	public float getOrdonnee() {
		return this.y;
	}

	public float getProfondeur() {
		return this.z;
	}
	
	public float setAbscisse(float a) {
		return this.x=this.x+a;
	}
	
	public float setOrdonnee(float o) {
		return this.y=this.y+o;
	}
	
	public float setProfondeur(float p) {
		return this.z=this.z+p;
	}
	


}






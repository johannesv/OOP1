
public class Komponent {
	String nimi;
	float mass;
	float toukejoud;
	float minohutakistus;
	float maxohutakistus;
	Komponent(String nimi, float mass, float toukejoud, float minohutakistus, float maxohutakistus){
		this.nimi = nimi;
		this.mass = mass;
		this.toukejoud = toukejoud;
		this.minohutakistus = minohutakistus;
		this.maxohutakistus = maxohutakistus;
	}
	Komponent(String nimi){
		this(nimi, 0, 0, 0, 0);
	}
	void setNimi(String uusnimi){
		this.nimi = uusnimi;
	}
	String getNimi(){
		return nimi;
	}
	void setMass(float uusmass){
		this.mass = uusmass;
	}
	float getMass(){
		return mass;
	}
	void setToukejoud(float touge){
		this.toukejoud = touge;
	}
	float getToukejoud(){
		return toukejoud;
	}
	public float getMinohutakistus() {
		return minohutakistus;
	}
	public void setMinohutakistus(float minohutakistus) {
		this.minohutakistus = minohutakistus;
	}
	public float getMaxohutakistus() {
		return maxohutakistus;
	}
	public void setMaxohutakistus(float maxohutakistus) {
		this.maxohutakistus = maxohutakistus;
	}
	
	public String toString() {
		return "Komponent: \nNimi: " + this.nimi +
				"\nMass: " + this.mass +
				"\nTõukejõud: " + this.toukejoud +
				"\nMinimaalne õhutakistus: " + this.minohutakistus +
				"\nMaksimaalne õhutakistus: " + this.maxohutakistus; 
		
	}
}

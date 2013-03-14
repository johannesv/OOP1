
public class Komponent {
	String nimi;
	float tyhiMass;
	float taisMass;
	public float getTyhiMass() {
		return tyhiMass;
	}
	public void setTyhiMass(float tyhiMass) {
		this.tyhiMass = tyhiMass;
	}
	public float getTaisMass() {
		return taisMass;
	}
	public void setTaisMass(float taisMass) {
		this.taisMass = taisMass;
	}

	float toukejoud;
	float minohutakistus;
	float maxohutakistus;
	Komponent(String nimi, float tyhiMass, float taisMass, float toukejoud, float minohutakistus, float maxohutakistus){
		this.nimi = nimi;
		this.tyhiMass = tyhiMass;
		this.taisMass = taisMass;
		this.toukejoud = toukejoud;
		this.minohutakistus = minohutakistus;
		this.maxohutakistus = maxohutakistus;
	}
	Komponent(String nimi){
		this(nimi, 0, 0, 0, 0, 0);
	}
	void setNimi(String uusnimi){
		this.nimi = uusnimi;
	}
	String getNimi(){
		return nimi;
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
				"\nTühimass: " + this.tyhiMass +
				"\nTäismass: " + this.taisMass +
				"\nTõukejõud: " + this.toukejoud +
				"\nMinimaalne õhutakistus: " + this.minohutakistus +
				"\nMaksimaalne õhutakistus: " + this.maxohutakistus; 
		
	}
}

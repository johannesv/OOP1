
public class Komponent {
	String nimi;
	float mass;
	float toukejoud;
	float ohutakistus;
	Komponent(String nimi, float mass, float toukejoud, float ohutakistus){
		this.nimi = nimi;
		this.mass = mass;
		this.toukejoud = toukejoud;
		this.ohutakistus = ohutakistus;
	}
	Komponent(String nimi){
		this(nimi, 0, 0, 0);
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
	void setTakistus(float takistus){
		this.ohutakistus = takistus;
	}
	float getTakistus(){
		return ohutakistus;
	}
	
}

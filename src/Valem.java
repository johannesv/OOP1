
public class Valem {

	public static float deltaV(float Isp, float tyhimass, float taismass){
		float dv = (float)(9.81 * Isp * Math.log((double)(taismass/tyhimass)));
		return dv;
	}
	public static float radiusShiftV(float algRadius, float targetRadius){
		float myy = (float)3530.461;
		float dv1 = (float)Math.sqrt((double)myy/(double)algRadius)*((float)Math.sqrt((double)(2*targetRadius/(algRadius+targetRadius)))-1);
		float dv2 = (float)Math.sqrt((double)myy/(double)targetRadius)*(1-(float)Math.sqrt((double)(2*algRadius/(algRadius+targetRadius))));
		return (dv1+dv2)*1000;
	}
	public static float OrbitV(float Radius){
		return (float)Math.sqrt(3530.461/(double)Radius)*1000;
	}
	
	
	public static void main(String args[]) {
		System.out.println("Kiiruse muutus 2,25 tonnisel kütusemahutil on "+deltaV((float)215,(float)250,(float)2250)+" m/s");
		System.out.println("Kiiruse muutus 100 km-lt 200 km-le on "+radiusShiftV(100, 200)+" m/s");
		System.out.println("Kiirus 100 km orbiidil on "+OrbitV(100)+ " m/s");
		System.out.println("Kiirus 200 km orbiidil on "+OrbitV(200)+ " m/s");
	}
	
}

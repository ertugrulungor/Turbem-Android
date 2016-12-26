
public abstract class Tasit {
	
	public String Marka;
	public String Model;
	public double Agirlik;
	public double Hacim;
	
	public abstract String Calis();
	public String HareketEt()
	{
		return "Hareket Ediyor";
	}
	public abstract String Dur();

}

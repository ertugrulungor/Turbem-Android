
public class Araba extends KaraTasiti {
	
	
	private String YakitTuru;
	
	@Override
	public String Calis() {
		return "Araba Çalıştı";
	}

	@Override
	public String Dur() {
		
		return "Araba Durdu";
	}
	public Araba(String yakitTuru)
	{
		this.YakitTuru = yakitTuru;
	}
	public String Goster()
	{
		return "Yakit Turu: " + YakitTuru;
	}
	
	
	

}

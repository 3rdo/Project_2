
public class Card
{
	private String rarity;
	private String name;
	private int percentOfReceiving;

	public Card(String rarity, String name, int percentOfReceiving)
	{
		this.rarity = rarity;
		this.name = name;
		this.percentOfReceiving = percentOfReceiving;
	}
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	public void setPercentOfReceiving(int percentOfReceiving){
        this.percentOfReceiving = percentOfReceiving;
    }

	public void setName(String name){
		this.name = name;
	}
	
	public String getRarity(){
		return rarity;
	}
	
	public int getPercentOfReceiving() {
		return percentOfReceiving;
	}

	public String getName(){
		return name;
	}
}

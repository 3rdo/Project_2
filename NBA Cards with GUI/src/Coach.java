
public class Coach extends Card
{
	private int receivingBoost;
	
	public Coach(String rarity, String name, int percentOfReceiving, int receivingBoost) 
	{
		super(rarity, name, percentOfReceiving);
        this.receivingBoost = receivingBoost;
	}
	
	public void setReceivingBoost(int receivingBoost) {
		this.receivingBoost = receivingBoost;
	}
	
	public int getReceivingBoost() {
		return receivingBoost;
	}
	
	public String toString() {
		return "Gives +2% boost to uncommon cards or better";
	}
}

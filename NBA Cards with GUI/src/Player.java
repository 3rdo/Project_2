
public class Player extends Card
{
	private String team;
	private int totalPoints;
	private int totalAssists;
	private int totalRebounds;
	private int totalSteals;
	private double avgPoints;
	private double avgAssists;

	public Player (String rarity, String name, int percentOfReceiving, String team, int totalPoints, int totalAssists, int totalRebounds,
    int totalSteals, double avgPoints, double avgAssists)
    {
		super(rarity, name, percentOfReceiving);
        this.team = team;
        this.totalPoints = totalPoints;
        this.totalAssists = totalAssists;
        this.totalRebounds = totalRebounds;
        this.totalSteals = totalSteals;
        this.avgPoints = avgPoints;
        this.avgAssists = avgAssists;
    }
    public void setTeam(String team){
        this.team = team;
    }

    public void setTotalPoints(int totalPoints) {
    	this.totalPoints = totalPoints;
    }
    
    public void setTotalAssists(int totalAssists) {
    	this.totalAssists = totalAssists;
    }
    
    public void setTotalRebounds(int totalRebounds) {
    	this.totalRebounds = totalRebounds;
    }
    
    public void setTotalSteals(int totalSteals) {
    	this.totalSteals = totalSteals;
    }
    
    public void setAvgPoints(double avgPoints) {
    	this.avgPoints = avgPoints;
    }
    
    public void setAvgAssists(double avgAssists) {
    	this.avgAssists = avgAssists;
    }
    
    public String getTeam() {
    	return team;
    }
    
    public int getTotalPoints(){
    	return totalPoints;
    }
    
    public int getTotalAssists() {
    	return totalAssists;
    }
    
    public int getTotalRebounds() {
    	return totalRebounds;
    }
    
    public int getTotalSteals() {
    	return totalSteals;
    }
    
    public double getAvgPoints() {
    	return avgPoints;
    }
    
    public double getAvgAssists() {
    	return avgAssists;
    }
    public String toString() {
    	return 
    			team + "\n" + 
    			"Total Points: " + totalPoints + "\n" +
    			"Total Assists: " + totalAssists + "\n" +
    			"Total Rebounds: " + totalRebounds + "\n" +
    			"Total Steals: " + totalSteals + "\n" +
    			"Avarage Points: " + avgPoints + "\n" +
    			"Avarage Assists: " + avgAssists;
    }
}

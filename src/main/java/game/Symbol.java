package game;

enum SymbolType {
    STANDARD,
    BONUS
}

public class Symbol {
    private String name;
    private SymbolType type;
    private double rewardMultiplier;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SymbolType getType() {
		return type;
	}
	public void setType(SymbolType type) {
		this.type = type;
	}
	public double getRewardMultiplier() {
		return rewardMultiplier;
	}
	public void setRewardMultiplier(double rewardMultiplier) {
		this.rewardMultiplier = rewardMultiplier;
	}

    
}


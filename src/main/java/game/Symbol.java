package game;

enum SymbolType {
    STANDARD,
    BONUS
}

public class Symbol {
    private String name;
    private SymbolType type;
    private double rewardMultiplier;
    
    public Symbol(String name, SymbolType type, double rewardMultiplier) {
        this.name = name;
        this.type = type;
        this.rewardMultiplier = rewardMultiplier;
    }
    
	public Symbol(String next, SymbolType bonus) {
		// TODO Auto-generated constructor stub
	}

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

	public static Object values() {
		// TODO Auto-generated method stub
		return null;
	}

    
}


package game;

import java.util.List;

public class WinningCombination {
    private int rewardMultiplier;
    private String when; // same_symbols or linear_symbols
    private int count; // Number of symbols in the winning combination
    private String group; // Group to which this winning combination belongs
    private List<List<String>> coveredAreas; // Covered areas for linear_symbols
	public int getRewardMultiplier() {
		return rewardMultiplier;
	}
	public void setRewardMultiplier(int rewardMultiplier) {
		this.rewardMultiplier = rewardMultiplier;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<List<String>> getCoveredAreas() {
		return coveredAreas;
	}
	public void setCoveredAreas(List<List<String>> coveredAreas) {
		this.coveredAreas = coveredAreas;
	}

    
}

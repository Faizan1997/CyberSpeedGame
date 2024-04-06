package game;

import java.util.List;
import java.util.Map;

public class Configuration {
 private int columns;
 private int rows;
 private List<ProbableSymbol> standardSymbols;
 private ProbableSymbol bonusSymbols;
 private Map<String, WinningCombination> winCombinations;
public int getColumns() {
	return columns;
}
public void setColumns(int columns) {
	this.columns = columns;
}
public int getRows() {
	return rows;
}
public void setRows(int rows) {
	this.rows = rows;
}
public List<ProbableSymbol> getStandardSymbols() {
	return standardSymbols;
}
public void setStandardSymbols(List<ProbableSymbol> standardSymbols) {
	this.standardSymbols = standardSymbols;
}
public ProbableSymbol getBonusSymbols() {
	return bonusSymbols;
}
public void setBonusSymbols(ProbableSymbol bonusSymbols) {
	this.bonusSymbols = bonusSymbols;
}
public Map<String, WinningCombination> getWinCombinations() {
	return winCombinations;
}
public void setWinCombinations(Map<String, WinningCombination> winCombinations) {
	this.winCombinations = winCombinations;
}

 
}


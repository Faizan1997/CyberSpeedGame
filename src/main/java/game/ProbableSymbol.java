package game;

import java.util.Map;

public class ProbableSymbol {
    private int column;
    private int row;
    private Map<String, Double> symbols; // Map of symbol name to its probability
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public Map<String, Double> getSymbols() {
		return symbols;
	}
	public void setSymbols(Map<String, Double> symbols) {
		this.symbols = symbols;
	}

    
}

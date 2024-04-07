package game;

import java.util.*;

public class GameLogic {
    private Configuration config;

    public GameLogic(Configuration config) {
        this.config = config;
    }

   
    public void play(int bettingAmount) {
        Symbol[][] matrix = generateMatrix();
        Map<Symbol, List<String>> appliedWinningCombinations = checkWinningCombinations(matrix);
        Symbol appliedBonusSymbol = applyBonuses(matrix);
        int reward = calculateReward(bettingAmount, appliedWinningCombinations, appliedBonusSymbol);
        outputResult(matrix, reward, appliedWinningCombinations, appliedBonusSymbol);
    }

    private Symbol[][] generateMatrix() {
        Random random = new Random();
        int rows = config.getRows();
        int columns = config.getColumns();
        Symbol[][] matrix = new Symbol[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double randomNumber = random.nextDouble() * 100; // generate random number between 0 to 100
                double cumulativeProbability = 0;
                for (ProbableSymbol probableSymbol : config.getProbabilities().getStandardSymbols()) {
                    cumulativeProbability += probableSymbol.getSymbols().values().iterator().next();
                    if (randomNumber <= cumulativeProbability) {
                        matrix[i][j] = new Symbol(probableSymbol.getSymbols().keySet().iterator().next(), SymbolType.STANDARD);
                        break;
                    }
                }
            }
        }
        return matrix;
    }

    private Map<Symbol, List<String>> checkWinningCombinations(Symbol[][] matrix) {
        Map<Symbol, List<String>> appliedWinningCombinations = new HashMap();
        for (Symbol symbol : Symbol.values()) {
            List<String> winningCombinations = new ArrayList();
            for (Map.Entry<String, WinningCombination> entry : config.getWinCombinations().entrySet()) {
                WinningCombination winningCombination = entry.getValue();
                if (winningCombination.getWhen().equals( WinningCombinationCondition.SAME_SYMBOLS)) {
                    int count = 0;
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if (matrix[i][j].equals(symbol)) {
                                count++;
                            }
                        }
                    }
                    if (count >= winningCombination.getCount()) {
                        winningCombinations.add(entry.getKey());
                    }
                }
            }
            appliedWinningCombinations.put(symbol, winningCombinations);
        }
        return appliedWinningCombinations;
    }
    
    private Symbol applyBonuses(Symbol[][] matrix) {
        Random random = new Random();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int randomRow = random.nextInt(rows);
        int randomColumn = random.nextInt(columns);
        Symbol symbol = matrix[randomRow][randomColumn];
        if (symbol.getType() == SymbolType.STANDARD) {
            double randomNumber = random.nextDouble() * 100;
            double cumulativeProbability = 0;
            for (ProbableSymbol probableSymbol : config.getProbabilities().getBonusSymbols()) {
                cumulativeProbability += probableSymbol.getSymbols().values().iterator().next();
                if (randomNumber <= cumulativeProbability) {
                    Symbol bonusSymbol = new Symbol(probableSymbol.getSymbols().keySet().iterator().next(), SymbolType.BONUS);
                    matrix[randomRow][randomColumn] = bonusSymbol;
                    return bonusSymbol;
                }
            }
        }
        return null;
    }


    private int calculateReward(int bettingAmount, Map<Symbol, List<String>> appliedWinningCombinations, Symbol appliedBonusSymbol) {
        int totalReward = 0;
        for (Map.Entry<Symbol, List<String>> entry : appliedWinningCombinations.entrySet()) {
            Symbol symbol = entry.getKey();
            for (String combination : entry.getValue()) {
                WinningCombination winningCombination = config.getWinCombinations().get(combination);
                int rewardMultiplier = winningCombination.getRewardMultiplier();
                totalReward += (bettingAmount * symbol.getRewardMultiplier() * rewardMultiplier);
            }
        }
        if (appliedBonusSymbol != null) {
            String bonusSymbolName = appliedBonusSymbol.getName();
            if (bonusSymbolName.equals("10x")) {
                totalReward *= 10;
            } else if (bonusSymbolName.equals("5x")) {
                totalReward *= 5;
            } else if (bonusSymbolName.equals("+1000")) {
                totalReward += 1000;
            } else if (bonusSymbolName.equals("+500")) {
                totalReward += 500;
            }
        }
        return totalReward;
    }


    private void outputResult(Symbol[][] matrix, int reward, Map<Symbol, List<String>> appliedWinningCombinations, Symbol appliedBonusSymbol) {
        // Print the matrix
        System.out.println("Matrix:");
        for (Symbol[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
        // Print the reward
        System.out.println("Reward: " + reward);
        
        // Print applied winning combinations
        System.out.println("Applied Winning Combinations:");
        for (Map.Entry<Symbol, List<String>> entry : appliedWinningCombinations.entrySet()) {
            Symbol symbol = entry.getKey();
            List<String> combinations = entry.getValue();
            System.out.println(symbol + ": " + combinations);
        }
        
        // Print applied bonus symbol
        System.out.println("Applied Bonus Symbol: " + appliedBonusSymbol);
    }
}



 


 
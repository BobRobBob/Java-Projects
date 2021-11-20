public class FiveModel {

    private int c;
    private FiveCell[][] cells;
    private boolean isCrossTurn = true;
    private String winner;

    public FiveModel(int c) {
        this.c = c;
        cells = new FiveCell[c][c];
        for (int i=0; i<c; i++) {
            for (int j=0; j<c; j++) {
                cells[i][j] = FiveCell.EMPTY;
            }
        }
    }

    public int getWidth() {
        return c;
    }

    public FiveCell getCell(int i, int j) {
        if (0 <= i && i < cells.length &&
                0 <= j && j < cells[i].length) {
            return cells[i][j];
        } else {
            return FiveCell.EMPTY;
        }
    }

    private boolean hasFiveEqualInDir(int i, int j, FiveCell c, int dx, int dy) {
        for (int k=0; k<5; k++) {
            if (getCell(i+dx*k,j+dy*k) != c) { return false; }
        }
        return true;
    }

    private boolean hasFiveInARowFrom(int i, int j) {
        FiveCell c = getCell(i,j);
        if (c == FiveCell.EMPTY) { return false; }
        return hasFiveEqualInDir(i,j,c,1,0) ||
                hasFiveEqualInDir(i,j,c,0,1) ||
                hasFiveEqualInDir(i,j,c,-1,0) ||
                hasFiveEqualInDir(i,j,c,0,-1) ||
                hasFiveEqualInDir(i,j,c,1,1) ||
                hasFiveEqualInDir(i,j,c,1,-1) ||
                hasFiveEqualInDir(i,j,c,-1,-1) ||
                hasFiveEqualInDir(i,j,c,-1,1);
    }

    public boolean isGameOver() {
        for (int i=0; i<c; i++) {
            for (int j=0; j<c; j++) {
                if (hasFiveInARowFrom(i,j)) {
                    if(isCrossTurn) {
                        winner = "Ring";
                    } else {
                        winner = "Cross";
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void clickIndex(int i, int j) {
        if (0 <= i && i < cells.length &&
                0 <= j && j < cells[i].length &&
                cells[i][j] == FiveCell.EMPTY && !isGameOver()) {
            FiveCell c;
            if (isCrossTurn) {
                c = FiveCell.CROSS;
            } else {
                c = FiveCell.RING;
            }
            cells[i][j] = c;
            isCrossTurn = !isCrossTurn;
        }
    }

    public String toString() {
        String res = "";
        for (int i=0; i<c; i++) {
            for (int j=0; j<c; j++) {
                if (cells[i][j] == FiveCell.CROSS) {
                    res += "x";
                } else if (cells[i][j] == FiveCell.RING) {
                    res += "o";
                } else {
                    res += ".";
                }
            }
            res += "\n";
        }
        return res;
    }

    public String getWinner(){
        return winner;
    }
}

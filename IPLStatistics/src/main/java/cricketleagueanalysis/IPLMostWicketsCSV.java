package cricketleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWicketsCSV {
    @CsvBindByName(column = "POS")
    public int position;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "Mat")
    public int matches;

    @CsvBindByName(column = "Inns")
    public int inning;

    @CsvBindByName(column = "Ov")
    public double over;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "Wkts")
    public int wickets;

    @CsvBindByName(column = "BBI")
    public int bestBallingInning;

    @CsvBindByName(column = "Avg")
    public double average;

    @CsvBindByName(column = "Econ")
    public double economy;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "4w")
    public int fourWkt;

    @CsvBindByName(column = "5w")
    public int fiveWicket;

    public IPLMostWicketsCSV(){}

    public IPLMostWicketsCSV(int position, String player, int runs, double bowlingAverage, int matches, double strikeRate, double economy, int fourWkt, int fiveWicket, int wickets) {
        this.position = position;
        this.player = player;
        this.matches = matches;
        this.runs = runs;
        this.average = bowlingAverage;
        this.matches = matches;
        this.strikeRate = strikeRate;
        this.economy = economy;
        this.fourWkt = fourWkt;
        this.fiveWicket = fiveWicket;
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return "IPLMostWicketsCSV{" +
                "position=" + position +
                ", player='" + player + '\'' +
                ", matches=" + matches +
                ", inning=" + inning +
                ", over=" + over +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bestBallingInning=" + bestBallingInning +
                ", average=" + average +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fourWkt=" + fourWkt +
                ", fiveWicket=" + fiveWicket +
                '}';
    }
}

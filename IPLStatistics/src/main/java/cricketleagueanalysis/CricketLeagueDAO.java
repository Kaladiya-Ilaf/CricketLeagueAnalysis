package cricketleagueanalysis;

public class CricketLeagueDAO {
    public int position;
    public String player;
    public int matches;
    public int runs;
    public int sixes;
    public double batsManAverage;
    public double bowlingAverage;
    public double strikeRate;
    public int fours;
    public double economy;
    public int fourWkt;
    public int fiveWicket;
    public int wickets;

    public CricketLeagueDAO(IPLMostRunsCSV iplRunsCsv) {
        position = iplRunsCsv.position;
        player = iplRunsCsv.player;
        matches = iplRunsCsv.matches;
        runs = iplRunsCsv.runs;
        strikeRate = iplRunsCsv.strikeRate;
        sixes = iplRunsCsv.sixes;
        batsManAverage = iplRunsCsv.average;
        fours = iplRunsCsv.fours;
    }

    public CricketLeagueDAO(IPLMostWicketsCSV iplWicketCsv) {
        position = iplWicketCsv.position;
        player = iplWicketCsv.player;
        matches = iplWicketCsv.matches;
        runs = iplWicketCsv.runs;
        strikeRate = iplWicketCsv.strikeRate;
        bowlingAverage = iplWicketCsv.average;
        economy = iplWicketCsv.economy;
        fiveWicket = iplWicketCsv.fiveWicket;
        fiveWicket = iplWicketCsv.fiveWicket;
        wickets = iplWicketCsv.wickets;
    }

}
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
    public double bowlingStrikeRate;
    public int fours;
    public double economy;
    public int fourWkt;
    public int fiveWicket;
    public int wickets;
    public int hundreds;
    public int fifties;

    public CricketLeagueDAO(IPLMostRunsCSV iplRunsCsv) {
        position = iplRunsCsv.position;
        player = iplRunsCsv.player;
        matches = iplRunsCsv.matches;
        runs = iplRunsCsv.runs;
        strikeRate = iplRunsCsv.strikeRate;
        sixes = iplRunsCsv.sixes;
        batsManAverage = iplRunsCsv.average;
        fours = iplRunsCsv.fours;
        hundreds = iplRunsCsv.hundreds;
        fifties = iplRunsCsv.fiftys;
    }

    public CricketLeagueDAO(IPLMostWicketsCSV iplWicketCsv) {
        position = iplWicketCsv.position;
        player = iplWicketCsv.player;
        matches = iplWicketCsv.matches;
        runs = iplWicketCsv.runs;
        bowlingStrikeRate = iplWicketCsv.strikeRate;
        bowlingAverage = iplWicketCsv.average;
        economy = iplWicketCsv.economy;
        fiveWicket = iplWicketCsv.fiveWicket;
        fiveWicket = iplWicketCsv.fiveWicket;
        wickets = iplWicketCsv.wickets;
    }

    public CricketLeagueDAO() {
    }

    public Object getCricketDTO(CricketLeagueAnalyser.PlayerType playerType) {
        if (playerType.equals(CricketLeagueAnalyser.PlayerType.BATSMAN))
            return new IPLMostRunsCSV(position, player, matches, runs, strikeRate, sixes, batsManAverage, fours);
        return new IPLMostWicketsCSV(position, player, runs, bowlingAverage, matches, strikeRate, economy, fourWkt, fiveWicket, wickets);
    }
}

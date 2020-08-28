package cricketleagueanalysis;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortByField {
    static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
    enum Field {
        AVERAGE_OF_BATSMAN,
        BATTING_STRIKE_RATE,
        SIX_AND_FOURS_WITH_STRIKE_RATE,
        AVERAGE_WITH_BEST_STRIKE_RATE,
        MAXIMUM_RUNS_WITH_BEST_AVERAGES,
        AVERAGE_OF_BOWLING,
        BOWLING_STRIKE_RATE,
        SIX_AND_FOURS,
        ECONOMY_RATE,
        BEST_STRIKING_RATE_WITH_4AND5WICKET
    }

    public static Comparator getComparatorField(SortByField.Field field) {
        Comparator<CricketLeagueDAO> iplAverageBattingComparator = Comparator.comparing(census -> census.batsManAverage);
        Comparator<CricketLeagueDAO> iplStrikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        Comparator<CricketLeagueDAO> iplSixComparator = Comparator.comparing(census -> (census.sixes * 6));
        Comparator<CricketLeagueDAO> iplFourComparator = Comparator.comparing(census -> (census.fours * 4));
        Comparator<CricketLeagueDAO> iplRunComparator = Comparator.comparing(census -> census.runs);
        Comparator<CricketLeagueDAO> iplAverageBowlingComparator = Comparator.comparing(census -> census.bowlingAverage);
        Comparator<CricketLeagueDAO> iplBowlerStrikeRateComparator = Comparator.comparing(census -> census.bowlingStrikeRate);
        Comparator<CricketLeagueDAO> iplEconomyRateComparator = Comparator.comparing(census -> census.economy);
        Comparator<CricketLeagueDAO> ipl4WicketComparator = Comparator.comparing(census -> (census.fourWkt * 4));
        Comparator<CricketLeagueDAO> ipl5WicketComparator = Comparator.comparing(census -> (census.fiveWicket * 5));

        sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN, iplAverageBattingComparator.reversed());
        sortFieldComparator.put(Field.BATTING_STRIKE_RATE, iplStrikeRateComparator.reversed());
        sortFieldComparator.put(Field.SIX_AND_FOURS, iplSixComparator.thenComparing(iplFourComparator).reversed());
        sortFieldComparator.put(Field.SIX_AND_FOURS_WITH_STRIKE_RATE, iplStrikeRateComparator.thenComparing(iplSixComparator).thenComparing(iplFourComparator).reversed());
        sortFieldComparator.put(Field.AVERAGE_WITH_BEST_STRIKE_RATE, iplAverageBattingComparator.thenComparing(iplStrikeRateComparator).reversed());
        sortFieldComparator.put(Field.MAXIMUM_RUNS_WITH_BEST_AVERAGES, iplRunComparator.thenComparing(iplAverageBattingComparator).reversed());
        sortFieldComparator.put(Field.AVERAGE_OF_BOWLING, iplAverageBowlingComparator.reversed());
        sortFieldComparator.put(Field.BOWLING_STRIKE_RATE, iplBowlerStrikeRateComparator.reversed());
        sortFieldComparator.put(Field.ECONOMY_RATE, iplEconomyRateComparator.reversed());
        sortFieldComparator.put(Field.BEST_STRIKING_RATE_WITH_4AND5WICKET, iplStrikeRateComparator.thenComparing(ipl4WicketComparator).thenComparing(ipl5WicketComparator).reversed());

        return (Comparator<CricketLeagueDAO>) sortFieldComparator.get(field);
    }
}

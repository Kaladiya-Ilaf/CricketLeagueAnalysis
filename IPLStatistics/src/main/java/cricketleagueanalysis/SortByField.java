package cricketleagueanalysis;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortByField {
    static Map<Field, Comparator> sortFieldComparator = new HashMap<>();
    enum Field {
        AVERAGE_OF_BATSMAN,
        STRIKE_RATE,
        SIX_AND_FOURS_WITH_STRIKE_RATE,
        AVERAGE_WITH_BEST_STRIKE_RATE,
        SIX_AND_FOURS
    }

    public static Comparator getComparatorField(SortByField.Field field) {
        Comparator<CricketLeagueDAO> iplAverageBattingComparator = Comparator.comparing(census -> census.batsManAverage);
        Comparator<CricketLeagueDAO> iplStrikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        Comparator<CricketLeagueDAO> iplSixComparator = Comparator.comparing(census -> (census.sixes * 6));
        Comparator<CricketLeagueDAO> iplFourComparator = Comparator.comparing(census -> (census.fours * 4));


        sortFieldComparator.put(Field.AVERAGE_OF_BATSMAN, iplAverageBattingComparator.reversed());
        sortFieldComparator.put(Field.STRIKE_RATE, iplStrikeRateComparator.reversed());
        sortFieldComparator.put(Field.SIX_AND_FOURS, iplSixComparator.thenComparing(iplFourComparator).reversed());
        sortFieldComparator.put(Field.SIX_AND_FOURS_WITH_STRIKE_RATE, iplStrikeRateComparator.thenComparing(iplSixComparator).thenComparing(iplFourComparator).reversed());
        sortFieldComparator.put(Field.AVERAGE_WITH_BEST_STRIKE_RATE, iplAverageBattingComparator.thenComparing(iplStrikeRateComparator).reversed());

        return (Comparator<CricketLeagueDAO>) sortFieldComparator.get(field);

    }
}

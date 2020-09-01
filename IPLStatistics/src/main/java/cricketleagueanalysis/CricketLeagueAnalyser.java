package cricketleagueanalysis;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.toCollection;

public class CricketLeagueAnalyser {
    public enum PlayerType{
        BATSMAN,
        BOWLER,
        BOTH
    }

    Map<String, CricketLeagueDAO> cricketLeagueMap;

    public CricketLeagueAnalyser() {
        cricketLeagueMap = new HashMap<String, CricketLeagueDAO>();
    }

    public int loadIPLFactSheetData(PlayerType playerType, String... csvFilePath) throws CricketLeagueAnalyserException {
        cricketLeagueMap = new CricketLeagueDataLoader().loadIPLFactSheetData(playerType, csvFilePath);
        return cricketLeagueMap.size();
    }

    public String getFieldWiseSortedPlayersData(PlayerType playerType, SortByField.Field... field) throws CricketLeagueAnalyserException {
        Comparator<CricketLeagueDAO> cricketComparator = null;
        if (cricketLeagueMap == null || cricketLeagueMap.size() == 0)
            throw new CricketLeagueAnalyserException("NO_PLAYER_DATA", CricketLeagueAnalyserException.ExceptionType.NO_PLAYER_DATA);

        cricketComparator = SortByField.getComparatorField(field[0]);
        ArrayList censusDTOS = cricketLeagueMap.values()
                .stream()
                .sorted(cricketComparator)
                .map(cricketDAO -> cricketDAO.getCricketDTO(playerType))
                .collect(toCollection(ArrayList::new));

        return new Gson().toJson(censusDTOS);
    }
}

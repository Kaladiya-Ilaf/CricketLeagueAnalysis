package cricketleagueanalysis;

import java.util.HashMap;
import java.util.Map;

public class CricketLeagueAnalyser {
    public enum PlayerType{ BATSMAN, BOWLER };

    Map<String, CricketLeagueDAO> cricketLeagueMap = null;

    public CricketLeagueAnalyser() {
        cricketLeagueMap = new HashMap<String, CricketLeagueDAO>();
    }

    public int loadIPLFactSheetData(PlayerType playerType, String... csvFilePath) throws CricketLeagueAnalyserException {
        cricketLeagueMap = new CricketLeagueDataLoader().loadIPLFactSheetData(playerType, csvFilePath);
        return cricketLeagueMap.size();
    }
}

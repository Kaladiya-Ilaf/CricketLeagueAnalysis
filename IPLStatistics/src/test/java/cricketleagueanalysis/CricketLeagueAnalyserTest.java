package cricketleagueanalysis;

import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String CRICKET_LEAGUE_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIPLFactSheetMostRunsFile_whenProper_shouldReturnCorrectRecordCount() throws CricketLeagueAnalyserException {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            int numOfRecords = cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfRecords);

    }
}

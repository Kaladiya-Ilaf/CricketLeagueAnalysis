package cricketleagueanalysis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CricketLeagueAnalyserTest {
    private static final String CRICKET_LEAGUE_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_TYPE_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.txt";
    private static final String INCORRECT_DATA_CSV_FILE_PATH = "./src/test/resources/IncorrectData.csv";
    private static final String CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Test
    public void givenIPLFactSheetMostRunsFile_whenProper_shouldReturnCorrectRecordCount() throws CricketLeagueAnalyserException {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            int numOfRecords = cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100, numOfRecords);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenWrongPath_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, WRONG_CSV_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INPUT_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenWrongFileType_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, WRONG_TYPE_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INPUT_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenWrongDelimiter_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN,INCORRECT_DATA_CSV_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenWrongHeader_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, INCORRECT_DATA_CSV_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenProper_shouldReturnCorrectRecordCount() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
        int numOfRecords = cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        Assert.assertEquals(99, numOfRecords);
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenWrongPath_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, WRONG_CSV_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INPUT_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenWrongFileType_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, WRONG_TYPE_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INPUT_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenWrongDelimiter_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, INCORRECT_DATA_CSV_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenWrongHeader_shouldThrowCustomException() {
        try {
            CricketLeagueAnalyser cricketAnalyser = new CricketLeagueAnalyser();
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(CricketLeagueAnalyserException.class);
            cricketAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, INCORRECT_DATA_CSV_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM, e.type);
        }
    }

}

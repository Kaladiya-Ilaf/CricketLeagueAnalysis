package cricketleagueanalysis;

import com.google.gson.Gson;
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

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnBattingAverage_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BATSMAN, SortByField.Field.AVERAGE_OF_BATSMAN);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", cricketCSV[0].player);

    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnStrikingRateOfBatsman_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BATSMAN, SortByField.Field.BATTING_STRIKE_RATE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Ishant Sharma", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOn6sAnd4s_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
            String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BATSMAN, SortByField.Field.SIX_AND_FOURS);
            IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnStrikingRateAnd6sAnd4s_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BATSMAN, SortByField.Field.SIX_AND_FOURS_WITH_STRIKE_RATE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Ishant Sharma", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnBattingAveragesAndBestStrikingRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BATSMAN, SortByField.Field.AVERAGE_WITH_BEST_STRIKE_RATE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostRunsFile_whenSortedOnMaximumRunsAndBestAverages_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BATSMAN, CRICKET_LEAGUE_RUNS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BATSMAN, SortByField.Field.MAXIMUM_RUNS_WITH_BEST_AVERAGES);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("David Warner", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostwktsFile_whenSortedOnBowlingAverage_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.AVERAGE_OF_BOWLING);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenSortedOnStrikingRateOfBowlers_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.BOWLING_STRIKE_RATE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenSortedOnEconomyRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.ECONOMY_RATE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Ben Cutting", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenSortedOnvStrikingRateAnd5And4Wickets_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
            String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.BEST_STRIKING_RATE_WITH_4AND5WICKET);
            IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
            Assert.assertEquals("Alzarri Joseph", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenSortedOnBowlingAveragesAndBestStrikingRate_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.BOWLING_AVERAGE_WITH_STRIKE_RATE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsFile_whenSortedOnMaximumWicketsAndBowlingAverages_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOWLER, CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.MAXIMUM_WICKET_WITH_BEST_BOWLING_AVERAGE);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("Imran Tahir", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsAndIPLFactSheetMostRunsFiles_whenSortedOnBattingAndBowlingAverages_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOTH,CRICKET_LEAGUE_RUNS_CSV_FILE_PATH,CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOTH, SortByField.Field.BEST_AVERAGES_OF_BOTH);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("MS Dhoni", cricketCSV[0].player);
    }

    @Test
    public void givenIPLFactSheetMostWktsAndIPLFactSheetMostRunsFiles_whenSortedOnMostRunsAndWickets_shouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType.BOTH,CRICKET_LEAGUE_RUNS_CSV_FILE_PATH,CRICKET_LEAGUE_WICKETS_CSV_FILE_PATH);
        String playerWiseSortedData = cricketLeagueAnalyser.getFieldWiseSortedPlayersData(CricketLeagueAnalyser.PlayerType.BOWLER, SortByField.Field.ALL_ROUNDER);
        IPLMostRunsCSV[] cricketCSV = new Gson().fromJson(playerWiseSortedData, IPLMostRunsCSV[].class);
        Assert.assertEquals("David Warner", cricketCSV[0].player);
    }


}

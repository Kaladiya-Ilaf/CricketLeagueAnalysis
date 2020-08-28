package cricketleagueanalysis;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class CricketLeagueDataLoader {
    public <E> Map<String, CricketLeagueDAO> loadIPLFactSheetData(CricketLeagueAnalyser.PlayerType playerType, String... csvFilePath) throws CricketLeagueAnalyserException{
        if (playerType.equals(CricketLeagueAnalyser.PlayerType.BATSMAN))
            return this.loadIPLFactSheetData(IPLMostRunsCSV.class, csvFilePath);
        else if (playerType.equals(CricketLeagueAnalyser.PlayerType.BOWLER))
            return this.loadIPLFactSheetData(IPLMostWicketsCSV.class, csvFilePath);
        else if (playerType.equals(CricketLeagueAnalyser.PlayerType.BOTH))
            return this.loadIPLFactSheetData(IPLMostRunsCSV.class, csvFilePath);
        else throw new CricketLeagueAnalyserException("Incorrect player type", CricketLeagueAnalyserException.ExceptionType.INVALID_PLAYER);
    }
    private <E> Map<String, CricketLeagueDAO> loadIPLFactSheetData(Class<E> cricketCSVClass, String... csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, CricketLeagueDAO> cricketLeagueMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> cricketCSVIterator = csvBuilder.getCSVFileIterator(reader, cricketCSVClass);
            Iterable<E> cricketCSVIterable = () -> cricketCSVIterator;
            if(cricketCSVClass.getName().equals("cricketleagueanalysis.IPLMostRunsCSV")){
                StreamSupport.stream(cricketCSVIterable.spliterator(), false)
                        .map(IPLMostRunsCSV.class::cast)
                        .forEach(cricketCSV -> cricketLeagueMap.put(cricketCSV.player, new CricketLeagueDAO(cricketCSV)));
            }else if (cricketCSVClass.getName().equals("cricketleagueanalysis.IPLMostWicketsCSV")){
                StreamSupport.stream(cricketCSVIterable.spliterator(), false)
                        .map(IPLMostWicketsCSV.class::cast)
                        .forEach(cricketCSV -> cricketLeagueMap.put(cricketCSV.player, new CricketLeagueDAO(cricketCSV)));
            }
            if (csvFilePath.length == 1) {
                return cricketLeagueMap;
            }
            this.loadFactSheetData(cricketLeagueMap, csvFilePath[1]);
            return cricketLeagueMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), CricketLeagueAnalyserException.ExceptionType.INPUT_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), CricketLeagueAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }

    private static Map<String, CricketLeagueDAO> loadFactSheetData(Map<String, CricketLeagueDAO> cricketLeagueMap, String csvFilePath) throws CricketLeagueAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostWicketsCSV> stateCodeCSVIterator = csvBuilder.getCSVFileIterator(reader, IPLMostWicketsCSV.class);
            Iterable<IPLMostWicketsCSV> csvIterable = () -> stateCodeCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .filter(factSheet -> cricketLeagueMap.get(factSheet.player) != null)
                    .forEach(factSheet -> cricketLeagueMap.get(factSheet.player));
            return cricketLeagueMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), CricketLeagueAnalyserException.ExceptionType.INCORRECT_DATA_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }


}

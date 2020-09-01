package cricketleagueanalysis;

public class CricketLeagueAnalyserException extends Throwable {
    enum ExceptionType{
        INPUT_FILE_PROBLEM,
        INCORRECT_DATA_PROBLEM,
        INVALID_PLAYER,
        NO_PLAYER_DATA
    }

    ExceptionType type;

    public CricketLeagueAnalyserException(String message, ExceptionType type ) {
        super(message);
        this.type = type;
    }

    public CricketLeagueAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}

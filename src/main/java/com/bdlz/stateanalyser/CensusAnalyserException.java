package com.bdlz.stateanalyser;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_INCORRECT;
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

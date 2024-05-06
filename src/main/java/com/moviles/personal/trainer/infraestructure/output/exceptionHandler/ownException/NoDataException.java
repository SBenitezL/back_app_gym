package com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException;

import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.exceptionStructure.ErrorCode;

import lombok.Getter;

@Getter
public class NoDataException extends RuntimeException {
    private final String mesageKey;
    private final String code;

    public NoDataException(ErrorCode code) {
        super(code.getCode());
        this.mesageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public NoDataException(final String message) {
        super(message);
        this.mesageKey = ErrorCode.BAD_FORMAT.getMessageKey();
        this.code = ErrorCode.BAD_FORMAT.getCode();
    }
}

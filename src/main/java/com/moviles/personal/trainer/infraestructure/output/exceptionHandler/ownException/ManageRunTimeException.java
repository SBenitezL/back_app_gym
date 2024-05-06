package com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException;

import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.exceptionStructure.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ManageRunTimeException extends RuntimeException {
    protected ErrorCode errorCode;

    public abstract String formatException();
}

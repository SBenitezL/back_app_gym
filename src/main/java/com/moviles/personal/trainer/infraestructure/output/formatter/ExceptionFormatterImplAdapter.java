package com.moviles.personal.trainer.infraestructure.output.formatter;

import org.springframework.stereotype.Service;

import com.moviles.personal.trainer.application.output.ExceptionFormatterIntPort;
import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException.BadFormatException;
import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException.BusinessRuleException;
import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException.EntityExistsException;
import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException.EntityNotFoundException;
import com.moviles.personal.trainer.infraestructure.output.exceptionHandler.ownException.NoDataException;

@Service
public class ExceptionFormatterImplAdapter implements ExceptionFormatterIntPort {
    @Override
    public void returnResponseErrorEntityExists(String message) {
        EntityExistsException objException = new EntityExistsException(message);
        throw objException;
    }

    @Override
    public void returnResponseErrorEntityNotFound(String message) {
        EntityNotFoundException objException = new EntityNotFoundException(message);
        throw objException;
    }

    @Override
    public void returnResponseBusinessRuleViolated(String message) {
        BusinessRuleException objException = new BusinessRuleException(message);
        throw objException;
    }

    @Override
    public void returnResponseBadFormat(String message) {
        BadFormatException objException = new BadFormatException(message);
        throw objException;
    }

    @Override
    public void returNoData(String message) {
        NoDataException objException = new NoDataException(message);
        throw objException;
    }
}

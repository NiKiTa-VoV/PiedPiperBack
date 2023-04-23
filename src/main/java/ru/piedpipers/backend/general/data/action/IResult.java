package ru.piedpipers.backend.general.data.action;

import org.springframework.http.HttpStatus;

public interface IResult<E> {

    void setData(E data);

    E getData();

    boolean isOk();
    boolean isServerError();

    HttpStatus getActualStatus();
}

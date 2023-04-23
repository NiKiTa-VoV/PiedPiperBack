package ru.piedpipers.backend.general.message.intefaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public interface IResponse {
    @JsonIgnore
    HttpStatus defaultStatus();
}

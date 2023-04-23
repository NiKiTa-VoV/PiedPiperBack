package ru.piedpipers.backend.general.message.realization.user.auth;

import org.springframework.http.HttpStatus;
import ru.piedpipers.backend.general.message.intefaces.IResponse;

public record AuthResponse(String accessToken) implements IResponse {

    @Override
    public HttpStatus defaultStatus() {
        return HttpStatus.OK;
    }
}

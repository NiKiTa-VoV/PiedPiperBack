package ru.skzmk.backend.general.message.realization.misc;

import org.springframework.http.HttpStatus;
import ru.skzmk.backend.general.message.intefaces.IResponse;

public record InnParseResponse(String title, String ogrn, String ogrnReg,
                               String dateReg, String inn, String kpp,
                               String address, String manager, String capital,
                               boolean status, boolean reliable, String courtCases,
                               String debt) implements IResponse {

    @Override
    public HttpStatus defaultStatus() {
        return HttpStatus.OK;
    }
}

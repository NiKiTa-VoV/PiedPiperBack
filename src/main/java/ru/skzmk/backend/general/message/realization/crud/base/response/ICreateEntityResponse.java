package ru.skzmk.backend.general.message.realization.crud.base.response;

import org.springframework.http.HttpStatus;
import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IResponse;
import ru.skzmk.backend.general.message.realization.crud.base.ICreateEntity;

public interface ICreateEntityResponse<ID, E extends IEntity<ID>> extends ICreateEntity<E>, IResponse {
    ID getId();

    @Override
    default HttpStatus defaultStatus() {
        return HttpStatus.CREATED;
    }
}

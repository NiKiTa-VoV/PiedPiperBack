package ru.skzmk.backend.general.message.realization.crud.base.response;

import org.springframework.http.HttpStatus;
import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IResponse;
import ru.skzmk.backend.general.message.realization.crud.base.IReadEntity;

public interface IReadEntityResponse<E extends IEntity<?>> extends IReadEntity<E>, IResponse {
    @Override
    default HttpStatus defaultStatus() {
        return HttpStatus.OK;
    }
}

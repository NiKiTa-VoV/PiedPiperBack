package ru.skzmk.backend.general.message.realization.crud.response.update;

import org.springframework.http.HttpStatus;
import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.realization.crud.base.response.IUpdateEntityResponse;

public class UpdateEntityResponse<E extends IEntity<?>> implements IUpdateEntityResponse<E> {
    @Override
    public HttpStatus defaultStatus() {
        return HttpStatus.OK;
    }
}

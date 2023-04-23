package ru.piedpipers.backend.general.message.realization.crud.base.response;

import org.springframework.http.HttpStatus;
import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IResponse;
import ru.piedpipers.backend.general.message.realization.crud.base.IDeleteEntity;

public interface IDeleteEntityResponse<E extends IEntity<?>> extends IDeleteEntity<E>, IResponse {
    @Override
    default HttpStatus defaultStatus() {
        return HttpStatus.NO_CONTENT;
    }
}

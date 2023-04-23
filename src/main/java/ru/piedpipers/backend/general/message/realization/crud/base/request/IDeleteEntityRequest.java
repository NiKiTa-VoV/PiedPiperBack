package ru.piedpipers.backend.general.message.realization.crud.base.request;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IRequest;
import ru.piedpipers.backend.general.message.realization.crud.base.IDeleteEntity;

public interface IDeleteEntityRequest<ID, E extends IEntity<?>> extends IDeleteEntity<E>, IRequest {
}

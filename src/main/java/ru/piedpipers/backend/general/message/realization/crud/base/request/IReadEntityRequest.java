package ru.piedpipers.backend.general.message.realization.crud.base.request;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IRequest;
import ru.piedpipers.backend.general.message.realization.crud.base.IReadEntity;

public interface IReadEntityRequest<ID, E extends IEntity<ID>> extends IReadEntity<E>, IRequest {
}

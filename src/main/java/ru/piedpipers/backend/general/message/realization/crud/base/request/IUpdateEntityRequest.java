package ru.piedpipers.backend.general.message.realization.crud.base.request;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IRequest;
import ru.piedpipers.backend.general.message.realization.crud.base.IUpdateEntity;

public interface IUpdateEntityRequest<ID, E extends IEntity<ID>> extends IUpdateEntity<E>, IRequest {
}

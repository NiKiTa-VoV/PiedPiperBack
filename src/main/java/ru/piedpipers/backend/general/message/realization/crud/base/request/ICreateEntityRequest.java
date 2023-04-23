package ru.piedpipers.backend.general.message.realization.crud.base.request;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IRequest;
import ru.piedpipers.backend.general.message.realization.crud.base.ICreateEntity;

public interface ICreateEntityRequest<E extends IEntity<?>> extends ICreateEntity<E>, IRequest {
}

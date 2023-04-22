package ru.skzmk.backend.general.message.realization.crud.base.request;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IRequest;
import ru.skzmk.backend.general.message.realization.crud.base.IUpdateEntity;

public interface IUpdateEntityRequest<ID, E extends IEntity<ID>> extends IUpdateEntity<E>, IRequest {
}

package ru.skzmk.backend.general.message.realization.crud.base.request;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IRequest;
import ru.skzmk.backend.general.message.realization.crud.base.IDeleteEntity;

public interface IDeleteEntityRequest<ID, E extends IEntity<?>> extends IDeleteEntity<E>, IRequest {
}

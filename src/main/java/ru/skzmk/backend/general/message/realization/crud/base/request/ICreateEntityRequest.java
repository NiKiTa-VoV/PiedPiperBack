package ru.skzmk.backend.general.message.realization.crud.base.request;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IRequest;
import ru.skzmk.backend.general.message.realization.crud.base.ICreateEntity;

public interface ICreateEntityRequest<E extends IEntity<?>> extends ICreateEntity<E>, IRequest {
}

package ru.skzmk.backend.general.message.realization.crud.request.createandupdate;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.realization.crud.base.CrudType;
import ru.skzmk.backend.general.message.realization.crud.base.request.ICreateEntityRequest;
import ru.skzmk.backend.general.message.realization.crud.base.request.IUpdateEntityRequest;

public abstract class CreateAndUpdateEntityRequest<ID, E extends IEntity<ID>> implements ICreateEntityRequest<E>, IUpdateEntityRequest<ID, E> {
    @Override
    public CrudType getType() {
        return CrudType.CREATE_AND_UPDATE;
    }
}

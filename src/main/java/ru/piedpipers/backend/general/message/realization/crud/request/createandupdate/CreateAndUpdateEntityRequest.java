package ru.piedpipers.backend.general.message.realization.crud.request.createandupdate;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.realization.crud.base.request.ICreateEntityRequest;
import ru.piedpipers.backend.general.message.realization.crud.base.request.IUpdateEntityRequest;
import ru.piedpipers.backend.general.message.realization.crud.base.CrudType;

public abstract class CreateAndUpdateEntityRequest<ID, E extends IEntity<ID>> implements ICreateEntityRequest<E>, IUpdateEntityRequest<ID, E> {
    @Override
    public CrudType getType() {
        return CrudType.CREATE_AND_UPDATE;
    }
}

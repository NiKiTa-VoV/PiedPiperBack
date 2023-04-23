package ru.piedpipers.backend.general.message.realization.crud.base;


import ru.piedpipers.backend.database.model.IEntity;

public interface IDeleteEntity<E extends IEntity<?>> extends ICrudEntity<E> {
    @Override
    default CrudType getType() {
        return CrudType.DELETE;
    }
}

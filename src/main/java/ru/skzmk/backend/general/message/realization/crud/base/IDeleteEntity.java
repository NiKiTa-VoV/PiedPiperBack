package ru.skzmk.backend.general.message.realization.crud.base;


import ru.skzmk.backend.database.model.IEntity;

public interface IDeleteEntity<E extends IEntity<?>> extends ICrudEntity<E> {
    @Override
    default CrudType getType() {
        return CrudType.DELETE;
    }
}

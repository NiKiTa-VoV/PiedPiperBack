package ru.piedpipers.backend.general.data.handler.crud.message.interfaces;


import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IResponse;

@FunctionalInterface
public interface CreateResponseAction<E extends IEntity<?>, RE extends IResponse> {
    RE create(E entity);
}

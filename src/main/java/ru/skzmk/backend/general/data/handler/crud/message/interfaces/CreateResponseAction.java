package ru.skzmk.backend.general.data.handler.crud.message.interfaces;


import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IResponse;

@FunctionalInterface
public interface CreateResponseAction<E extends IEntity<?>, RE extends IResponse> {
    RE create(E entity);
}

package ru.skzmk.backend.general.data.handler.crud.manipulation;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.data.action.realization.ActionResult;

public interface ICrudService<E extends IEntity<ID>, ID> {
    ActionResult<E> create(E entity);

    ActionResult<E> read(ID id);

    ActionResult<E> update(ID id, E entity);

    ActionResult<E> delete(ID id);

    boolean existId(ID id);
}

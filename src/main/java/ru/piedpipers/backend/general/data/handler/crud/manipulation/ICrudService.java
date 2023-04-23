package ru.piedpipers.backend.general.data.handler.crud.manipulation;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.data.action.realization.ActionResult;

public interface ICrudService<E extends IEntity<ID>, ID> {
    ActionResult<E> create(E entity);

    ActionResult<E> read(ID id);

    ActionResult<E> update(ID id, E entity);

    ActionResult<E> delete(ID id);

    boolean existId(ID id);
}

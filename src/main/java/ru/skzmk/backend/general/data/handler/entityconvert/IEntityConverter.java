package ru.skzmk.backend.general.data.handler.entityconvert;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.data.action.realization.ActionResult;
import ru.skzmk.backend.general.message.intefaces.IRequest;
import ru.skzmk.backend.general.message.realization.crud.base.ICreateEntity;
import ru.skzmk.backend.general.message.realization.crud.base.IUpdateEntity;

public interface IEntityConverter<ID , E extends IEntity<ID>,
        RT_CREATE extends IRequest & ICreateEntity<E>,
        RT_UPDATE extends IRequest & IUpdateEntity<E>
        > {
    ActionResult<E> requestCreateToEntity(RT_CREATE request);

    ActionResult<E> requestUpdateToEntity(ID id, RT_UPDATE request);
}

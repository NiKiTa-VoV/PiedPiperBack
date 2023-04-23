package ru.piedpipers.backend.general.data.handler.entityconvert;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.data.action.realization.ActionResult;
import ru.piedpipers.backend.general.message.realization.crud.base.ICreateEntity;
import ru.piedpipers.backend.general.message.realization.crud.base.IUpdateEntity;
import ru.piedpipers.backend.general.message.intefaces.IRequest;

public interface IEntityConverter<ID , E extends IEntity<ID>,
        RT_CREATE extends IRequest & ICreateEntity<E>,
        RT_UPDATE extends IRequest & IUpdateEntity<E>
        > {
    ActionResult<E> requestCreateToEntity(RT_CREATE request);

    ActionResult<E> requestUpdateToEntity(ID id, RT_UPDATE request);
}

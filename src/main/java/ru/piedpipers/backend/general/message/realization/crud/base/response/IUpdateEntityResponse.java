package ru.piedpipers.backend.general.message.realization.crud.base.response;

import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.general.message.intefaces.IResponse;
import ru.piedpipers.backend.general.message.realization.crud.base.IUpdateEntity;

public interface IUpdateEntityResponse<E extends IEntity<?>> extends IUpdateEntity<E>, IResponse {

}

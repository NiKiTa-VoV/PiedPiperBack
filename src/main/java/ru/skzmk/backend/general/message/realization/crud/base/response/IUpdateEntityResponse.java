package ru.skzmk.backend.general.message.realization.crud.base.response;

import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.intefaces.IResponse;
import ru.skzmk.backend.general.message.realization.crud.base.IUpdateEntity;

public interface IUpdateEntityResponse<E extends IEntity<?>> extends IUpdateEntity<E>, IResponse {

}

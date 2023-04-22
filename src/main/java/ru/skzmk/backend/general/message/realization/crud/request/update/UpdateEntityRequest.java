package ru.skzmk.backend.general.message.realization.crud.request.update;

import lombok.Data;
import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.realization.crud.base.request.IUpdateEntityRequest;

import java.util.Map;

@Data
public class UpdateEntityRequest<ID, E extends IEntity<ID>> implements IUpdateEntityRequest<ID, E> {
    private Map<String, String> changedFields;
}

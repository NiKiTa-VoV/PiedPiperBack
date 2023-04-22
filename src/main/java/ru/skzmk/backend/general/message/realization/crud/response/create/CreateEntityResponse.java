package ru.skzmk.backend.general.message.realization.crud.response.create;

import lombok.Data;
import ru.skzmk.backend.database.model.IEntity;
import ru.skzmk.backend.general.message.realization.crud.base.response.ICreateEntityResponse;

@Data
public class CreateEntityResponse<ID, E extends IEntity<ID>> implements ICreateEntityResponse<ID, E> {
    private final ID id;
}

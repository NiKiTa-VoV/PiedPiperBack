package ru.skzmk.backend.general.message.realization.crud.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.skzmk.backend.database.model.IEntity;

public interface ICrudEntity<E extends IEntity<?>> {
    @JsonIgnore
    CrudType getType();
}

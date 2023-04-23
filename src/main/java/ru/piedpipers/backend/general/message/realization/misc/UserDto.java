package ru.piedpipers.backend.general.message.realization.misc;

import ru.piedpipers.backend.database.model.entity.Company;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public record UserDto(
        Integer id,
        @NotNull UUID uuid,
        @Email @NotBlank String email,
        Company company
) implements Serializable {
}

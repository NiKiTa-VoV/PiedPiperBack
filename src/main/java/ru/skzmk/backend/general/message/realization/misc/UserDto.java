package ru.skzmk.backend.general.message.realization.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public record UserDto(
        Integer id,
        @NotNull UUID uuid,
        @Email @NotBlank String email,
        ru.skzmk.backend.database.model.entity.Company company
) implements Serializable {
}

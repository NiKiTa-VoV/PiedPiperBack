package ru.piedpipers.backend.general.message.realization.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@Getter
public class CompanyDto implements Serializable {
    private final Integer id;
    @NotBlank
    private final String title;
    @NotBlank
    private final String ogrn;
    @NotBlank
    private final String ogrnReg;
    @NotBlank
    private final String dateReg;
    @NotBlank
    private final String inn;
    @NotBlank
    private final String kpp;
    @NotBlank
    private final String address;
    @NotBlank
    private final String capital;
    @NotBlank
    private final String manager;
    @NotBlank
    private final boolean status;
    @NotBlank
    private final boolean reliable;
    @NotBlank
    private final String courtCases;
    @NotBlank
    private final boolean debt;
}

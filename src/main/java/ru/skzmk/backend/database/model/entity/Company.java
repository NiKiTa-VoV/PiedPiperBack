package ru.skzmk.backend.database.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.skzmk.backend.database.model.IEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company implements IEntity<Integer> {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "company_id_generator")
    @SequenceGenerator(name = "company_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @NotBlank
    @Column(name = "title", nullable = false)
    String title;

    @NotBlank
    @Column(name = "ogrn", nullable = false)
    String ogrn;

    @NotBlank
    @Column(name = "ogrn_reg", nullable = false)
    String ogrnReg;

    @NotBlank
    @Column(name = "date_reg", nullable = false)
    String dateReg;

    @NotBlank
    @Column(name = "inn", nullable = false)
    String inn;

    @NotBlank
    @Column(name = "kpp", nullable = false)
    String kpp;

    @NotBlank
    @Column(name = "address", nullable = false)
    String address;

    @NotBlank
    @Column(name = "capital", nullable = false)
    String capital;

    @NotBlank
    @Column(name = "manager", nullable = false)
    String manager;

    @NotBlank
    @Column(name = "status", nullable = false)
    boolean status;

    @NotBlank
    @Column(name = "reliable", nullable = false)
    boolean reliable;

    @NotBlank
    @Column(name = "court_cases", nullable = false)
    String courtCases;

    @NotBlank
    @Column(name = "debt", nullable = false)
    boolean debt;
}

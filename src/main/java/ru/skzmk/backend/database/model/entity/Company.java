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
@Table(name = "application")
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
    @Column(name = "date_reg", nullable = false)
    String dateReg;

    @NotBlank
    @Column(name = "inn_kpp", nullable = false)
    String innKpp;

    @NotBlank
    @Column(name = "address", nullable = false)
    String address;

    @NotBlank
    @Column(name = "contact", nullable = false)
    String contact;

    @NotBlank
    @Column(name = "status", nullable = false)
    boolean status;

}

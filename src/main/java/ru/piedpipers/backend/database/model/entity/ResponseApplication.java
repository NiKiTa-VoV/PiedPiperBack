package ru.piedpipers.backend.database.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "response_application")
public class ResponseApplication {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "response_application_id_generator")
    @SequenceGenerator(name = "response_application_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;


}

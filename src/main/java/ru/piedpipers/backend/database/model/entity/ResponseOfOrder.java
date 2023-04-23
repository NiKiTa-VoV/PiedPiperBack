package ru.piedpipers.backend.database.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.piedpipers.backend.database.model.IEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "response_of_order")
public class ResponseOfOrder implements IEntity<Integer> {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "response_of_order_id_generator")
    @SequenceGenerator(name = "response_of_order_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "invitation", nullable = false)
    boolean invitation;

    @NotBlank
    @Column(name = "description", nullable = false)
    String description;

    @NotBlank
    @Column(name = "date", nullable = false)
    String date;
}

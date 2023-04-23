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
@Table(name = "document")
public class Document implements IEntity<Integer> {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "document_id_generator")
    @SequenceGenerator(name = "document_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @NotBlank
    @Column(name = "file_name", nullable = false)
    String fileName;
}

package ru.skzmk.backend.database.model.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.skzmk.backend.database.model.IEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login_history")
public class LoginHistory implements IEntity<Integer> {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "login_history_id_generator")
    @SequenceGenerator(name = "login_history_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @NotNull
    @Column(name = "date_and_time", nullable = false)
    Instant dateAndTime;
}

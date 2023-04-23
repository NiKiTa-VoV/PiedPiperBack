package ru.piedpipers.backend.database.model.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.piedpipers.backend.database.model.IEntity;
import ru.piedpipers.backend.database.model.entity.Company;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements IEntity<Integer> {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @NotNull
    @Column(name = "uuid", nullable = false)
    UUID uuid;

    @Email @NotBlank
    @Column(name = "email", nullable = false)
    String email;

    @NotBlank
    @Column(name = "password", nullable = false)
    String password;

    @Builder.Default
    @NotNull
    @Column(name = "disabled", nullable = false)
    Boolean disabled = false;

    @Builder.Default
    @NotNull
    @Column(name = "blocked", nullable = false)
    boolean blocked = false;

    @Builder.Default
    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(
            name = "assigned_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uuid")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    final Set<Role> roles = new LinkedHashSet<>();

    @OneToOne
    Company company;
}

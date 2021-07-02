package api.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name ="tbl_users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyUser")
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String name;

    @NotEmpty(message = "El apellido no debe ser vacío")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "El apellido no debe ser vacío")

    private String surname;

    @NotEmpty(message = "El rfc no debe ser vacío")
    private String rfc;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String worshift;

    @NotEmpty(message = "El genero no debe ser vacío")
    private String gender;

    @NotEmpty(message = "El telefono no debe ser vacío")
    private String phone;

    @NotEmpty(message = "El pin no debe ser vacío")
    private String pin;

    @NotEmpty(message = "La fecha de nacimiento no debe ser vacía")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
}

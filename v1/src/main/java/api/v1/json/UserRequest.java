package api.v1.json;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {
    private Long id;
    private String name;
    private String lastName;
    private String surname;
    private String rfc;
    private String worshift;
    private String gender;
    private String phone;
    private String pin;
    private String birthdate;
}

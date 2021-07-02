package api.v1.json;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserListResponse {

    private String keyUser;
    private String name;
    private String lastName;
    private String surname;
    private Profile profile;
    private String rfc;
    private Workshift Workshift;
    private boolean status;

}

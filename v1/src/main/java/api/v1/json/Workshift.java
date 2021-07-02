package api.v1.json;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Workshift {
    private String id;
    private String name;
}

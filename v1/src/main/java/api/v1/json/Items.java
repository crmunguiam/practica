package api.v1.json;

import api.v1.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Items {
  @JsonProperty("items")
  private List<UserListResponse> userList;

}

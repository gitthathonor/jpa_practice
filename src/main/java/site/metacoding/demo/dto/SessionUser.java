package site.metacoding.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.demo.domain.User;

@Getter
@Setter
@NoArgsConstructor
public class SessionUser {
    private Long id;
    private String username;

    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public User toEntity() {
        return User.builder().id(id).username(username).build();
    }

}

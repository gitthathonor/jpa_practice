package site.metacoding.demo.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.demo.domain.User;

public class UserReqDto {

    @Setter
    @Getter
    public static class JoinReqDto {
        private String username;
        private String password;
        private String email;

        public User toEntity() {
            return User.builder().username(username).password(password).email(email).build();
        }
    }
}

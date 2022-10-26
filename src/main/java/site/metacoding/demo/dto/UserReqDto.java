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

    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;

        public User toEntity() {
            return User.builder().username(username).password(password).build();
        }
    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        private String password;
        private String email;
        private Long id; // 서비스 로직

        public User toEntity() {
            return User.builder().password(password).email(email).id(id).build();
        }
    }
}

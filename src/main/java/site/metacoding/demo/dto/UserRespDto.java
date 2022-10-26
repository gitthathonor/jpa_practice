package site.metacoding.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.demo.domain.User;

public class UserRespDto {

    @Setter
    @Getter
    public static class JoinRespDto {
        private Long id;
        private String username;
        private String email;

        @Builder
        public JoinRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
        }

    }

    @Setter
    @Getter
    public static class UpdateRespDto {
        private Long id;
        private String password;
        private String email;

        @Builder
        public UpdateRespDto(User user) {
            this.id = user.getId();
            this.password = user.getPassword();
            this.email = user.getEmail();
        }

    }
}

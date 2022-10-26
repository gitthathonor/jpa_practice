package site.metacoding.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.demo.domain.User;
import site.metacoding.demo.dto.ResponseDto;
import site.metacoding.demo.dto.SessionUser;
import site.metacoding.demo.dto.UserReqDto.JoinReqDto;
import site.metacoding.demo.dto.UserReqDto.LoginReqDto;
import site.metacoding.demo.dto.UserRespDto.JoinRespDto;
import site.metacoding.demo.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinReqDto joinReqDto) {
        JoinRespDto joinRespDto = userService.save(joinReqDto);
        return new ResponseEntity<>(new ResponseDto<>(1, "ok", joinRespDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginReqDto LoginReqDto) {
        SessionUser sessionUser = userService.login(LoginReqDto);
        session.setAttribute("sessionUser", sessionUser);
        return new ResponseDto<>(1, "로그인 성공", sessionUser);
    }

}

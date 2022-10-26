package site.metacoding.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.demo.dto.ResponseDto;
import site.metacoding.demo.dto.SessionUser;
import site.metacoding.demo.dto.UserReqDto.JoinReqDto;
import site.metacoding.demo.dto.UserReqDto.LoginReqDto;
import site.metacoding.demo.dto.UserReqDto.UpdateReqDto;
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

    @PutMapping("/user/{id}")
    public ResponseDto<?> update(@PathVariable Long id, @RequestBody UpdateReqDto updateReqDto) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            return new ResponseDto<>(-1, "로그인이 필요합니다.", null);
        }
        updateReqDto.setId(id);
        return new ResponseDto<>(1, "수정 성공", userService.update(updateReqDto));
    }

    @DeleteMapping("/user/{id}")
    public ResponseDto<?> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseDto<>(1, "회원 탈퇴 성공", null);
    }

}

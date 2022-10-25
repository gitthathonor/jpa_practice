package site.metacoding.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.demo.domain.User;
import site.metacoding.demo.dto.ResponseDto;
import site.metacoding.demo.dto.UserReqDto.JoinReqDto;
import site.metacoding.demo.dto.UserRespDto.JoinRespDto;
import site.metacoding.demo.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinReqDto joinReqDto) {
        JoinRespDto joinRespDto = userService.save(joinReqDto);
        return new ResponseEntity<>(new ResponseDto<>(1, "ok", joinRespDto), HttpStatus.CREATED);
    }

}

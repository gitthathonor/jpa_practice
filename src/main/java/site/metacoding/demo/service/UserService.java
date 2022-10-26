package site.metacoding.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.demo.domain.User;
import site.metacoding.demo.domain.UserRepository;
import site.metacoding.demo.dto.SessionUser;
import site.metacoding.demo.dto.UserReqDto.JoinReqDto;
import site.metacoding.demo.dto.UserReqDto.LoginReqDto;
import site.metacoding.demo.dto.UserRespDto.JoinRespDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public JoinRespDto save(JoinReqDto joinReqDto) {
        User userPS = userRepository.save(joinReqDto.toEntity());
        return new JoinRespDto(userPS);
    }

    @Transactional(readOnly = true)
    public SessionUser login(LoginReqDto loginReqDto) {
        // 1. LoginReqDto에서 받은 username으로 DB에 User객체가 들어있는지 먼저 확인
        User userPS = userRepository.findByUsername(loginReqDto.getUsername());
        if (userPS.getPassword().equals(loginReqDto.getPassword())) {
            return new SessionUser(userPS);
        } else {
            throw new RuntimeException("회원정보가 없습니다.");
        }
        // 2. SessionUser 객체로 전환
    }
}

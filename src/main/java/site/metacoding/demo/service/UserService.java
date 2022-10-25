package site.metacoding.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.demo.domain.User;
import site.metacoding.demo.domain.UserRepository;
import site.metacoding.demo.dto.UserReqDto.JoinReqDto;
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
}

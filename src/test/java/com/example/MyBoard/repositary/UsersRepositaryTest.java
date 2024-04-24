package com.example.MyBoard.repositary;

import com.example.MyBoard.constant.Gender;
import com.example.MyBoard.entity.Users;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class UsersRepositaryTest {
    @Autowired
    UsersRepositary repositary;

    @Test @DisplayName("Users 테이블 입력 테스트")
    void inputUsers(){
        Users users = Users.builder()
                .name("홍길동")
                .email("test@test.com")
                .gender(Gender.Male)
                .likeColor("Red")
                .build();
        repositary.save(users);
    }
    @Test @DisplayName("Users 테이블 수정 테스트")
    void updateUsers(){
        Users users = Users.builder()
                .id(1L)
                .name("홍길순")
                .email("test@test.com")
                .gender(Gender.Female)
                .likeColor("Yellow")
                .build();
        repositary.save(users);
    }
}
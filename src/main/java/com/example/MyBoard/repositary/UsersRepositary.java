package com.example.MyBoard.repositary;

import com.example.MyBoard.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepositary extends JpaRepository<Users,Long> {

}

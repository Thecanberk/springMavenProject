package com.example.demo.repository.user;

import com.example.demo.model.user.User;
import com.example.demo.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByUserName(String userName);
}

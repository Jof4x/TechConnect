package com.upao.techconnect.service;

import com.upao.techconnect.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminUserService {
    List<User> findAll();
    Page<User> paginate(Pageable pageable);
    User create(User user);
    User findById(Integer id);

    @Transactional
    User update(Integer id, User updatedUser);

    void delete(Integer id);
}

package com.upao.techconnect.service.impl;

import com.upao.techconnect.model.entity.User;
import com.upao.techconnect.repository.UserRepository;
import com.upao.techconnect.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true) // LOGICA DE CREAR
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> paginate(Pageable pageable) {
        return null;
    }


    @Override
    @Transactional
    public User create(User user) {    // LOGICA OBTENER FECHA AUTOMATICA
        user.setRegisterAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)   // LOGICA BUSCAR POR ID
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró usuario con ese id " + id));
    }

    @Transactional
    @Override
    public User update(Integer id, User updatedUser) {   // LOGICA CREAR USUARIO
        User userFromDb = findById(id);
        userFromDb.setFirstName(updatedUser.getFirstName());
        userFromDb.setEmail(updatedUser.getEmail());
        userFromDb.setPassword(updatedUser.getPassword());
        userFromDb.setTypeuser(updatedUser.getTypeuser());
        userFromDb.setRegisterAt(LocalDateTime.now());
        return userRepository.save(userFromDb);
    }

    @Override
    @Transactional
    public void delete(Integer id) {   // LOGICA ELIMINAR
        User user = findById(id);
        userRepository.delete(user);
    }
}

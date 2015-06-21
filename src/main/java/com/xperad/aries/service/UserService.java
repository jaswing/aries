package com.xperad.aries.service;

import com.xperad.aries.exception.DuplicateUserException;
import com.xperad.aries.exception.UserNotFoundException;
import com.xperad.aries.persistence.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

public interface UserService extends UserDetailsService {

    void addUser(User user) throws DuplicateUserException;

    User addUserReturn(User user) throws DuplicateUserException;

    User getUser(int userId) throws UserNotFoundException;

    User getUser(String username) throws UserNotFoundException;

    void updateUser(User user) throws Exception;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteUser(int userId) throws Exception;

    List<User> getUsers() throws Exception;
}

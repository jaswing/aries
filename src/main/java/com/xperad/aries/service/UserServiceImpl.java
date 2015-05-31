package com.xperad.aries.service;

import com.xperad.aries.exception.DuplicateUserException;
import com.xperad.aries.exception.UserNotFoundException;
import com.xperad.aries.persistence.model.Role;
import com.xperad.aries.persistence.repository.RoleRepository;
import com.xperad.aries.persistence.repository.UserRepository;
import com.xperad.aries.persistence.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = false)
    public void addUser(User user) throws DuplicateUserException {
        Criterion criterion = Restrictions.eq("username", user.getUsername());
        List<User> usersToCheck = userRepository.findByCriteria(criterion);
        if (usersToCheck == null || usersToCheck.size() == 0) {
            Role userRole = roleRepository.read(2);
            user.setRole(userRole);
            user.setEnabled(true);
            user.setDateInfo(LocalDate.now());
            user.setTimeInfo(LocalDateTime.now());
            user.setZonedDateTime1(ZonedDateTime.now(ZoneId.of("Europe/Paris")));
            user.setZonedDateTime2(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));
            userRepository.create(user);
        } else {
            throw new DuplicateUserException("Creating user failed. (user exists)");
        }
    }

    @Override
    public User getUser(int userId) throws UserNotFoundException {
        User user = userRepository.read(userId);
        if (user == null) {
            throw new UserNotFoundException("Getting user failed. (user not exists)");
        } else {
            return user;
        }
    }

    @Override
    public User getUser(String username) throws UserNotFoundException {
        Criterion criterion = Restrictions.like("username", username, MatchMode.START);
        List<User> users = userRepository.findByCriteria(criterion);
        if (users == null) {
            throw new UserNotFoundException("user data is null");
        } else {
            if (users.size() == 0) {
                throw new UserNotFoundException("user data is zero");
            } else {
                logger.info("user data : " + users.size() + " / Get first record.");
                return users.get(0);
            }
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUser(User user) throws Exception {
        User userToUpdate = userRepository.read(user.getId());
        if (userToUpdate == null) {
            throw new UserNotFoundException("updating user failed. (user not exists)");
        } else {
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEnabled(user.isEnabled());
            userToUpdate.setRole(user.getRole());
            userRepository.update(userToUpdate);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(int userId) throws Exception {
        userRepository.delete(userId);
    }

    @Override
    public List<User> getUsers() throws Exception {
        return userRepository.readAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return getUser(username);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}

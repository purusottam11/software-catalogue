package com.purusottam.softwarecatalogue.service;


import com.purusottam.softwarecatalogue.model.User;

import java.time.Month;
import java.util.List;
import java.util.Map;

public interface UserService {

    User getUser(Long userId);

    List<User> getAllUsers();

    User addUser(User user);

    User updateUser(Long userId, User user);

    User findByEmailId(String emailId);

    List<User> listUsersSortedByName();

    List<User> listUsersSortedByAge();

    List<User> findUsersWithName(String searchString);

    List<User> findUsersInAgeRange(Integer minAge, Integer maxAge) throws Exception;

    List<User> findUsersByGender(User.Gender gender);

    Map<String, List<User>> groupUsersByState();

    Map<Month, List<User>> groupUsersByMonthOfBirth();

    boolean delete(String emailId) throws Exception;

}

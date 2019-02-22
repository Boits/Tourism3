package user.repo;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class UserMemoryRepo {

    List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public void deleteUserByEntity(User user) {
        userList.remove(user);
    }

    public void deleteUserByIndex(int index) {
        userList.remove(index);
    }

    public User findUserByPassport(Integer passport) {
        for (User user : userList) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public User findUserByLastName(String lastName) {
        for (User user : userList) {
            if (user.getLastName().equals(lastName)) {
                return user;
            }
        }
        return null;
    }

    public Integer findUserIndexByEntity(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(user)) {
                return i;
            }
        }
        return null;
    }


    public void deleteUserByPassport(Integer passport) {
        for (User user : userList) {
            if (user.getPassport().equals(passport)) {
                deleteUserByEntity(user);
            }
        }
    }

    public void printUsers() {
        System.out.println("All users:");
        for (User user : userList) {
            System.out.print(user + " | ");
        }
    }
}
package user.repo.impl;

import common.solution.utils.ArrayUtils;
import storage.SequenceGenerator;
import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;
import static storage.Storage.userArray;

import java.util.Collections;
import java.util.List;

public class UserMemoryArrayRepo implements UserRepo {
    private int userIndex = -1;

    @Override
    public void add(User user) {
        if (userIndex == userArray.length - 1) {
            User[] newArrUsers = new User[userArray.length * 2];
            System.arraycopy(userArray, 0, newArrUsers, 0, userArray.length);
            userArray = newArrUsers;
        }

        userIndex++;
        user.setId(SequenceGenerator.getNextValue());
        userArray[userIndex] = user;
    }

//    public void sort() {
//        Collections.sort(userList);
//    }

    @Override
    public void update(User user) {
        //we already in memory, no need to update object
    }

    @Override
    public User findById(long id) {
        Integer userIndex = findUserIndexById(id);
        if (userIndex != null) {
            return userArray[userIndex];
        }

        return null;
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(long id) {
        Integer userIndex = findUserIndexById(id);

        if (userIndex != null) {
            deleteUserByIndex(userIndex);
        }
    }

    private void deleteUserByIndex(int index) {
        ArrayUtils.removeElement(userArray, index);
        userIndex--;
    }

    @Override
    public void printAll() {
        for (User user : userArray) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    private Integer findUserIndexById(long userId) {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null && Long.valueOf(userId).equals(userArray[i].getId())) {
                return i;
            }
        }
        return null;
    }

}

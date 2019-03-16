package user.repo.impl.memory;

import static storage.Storage.userList;

import storage.SequenceGenerator;
import user.domain.User;
import user.repo.UserRepo;
import user.search.UserSearchCondition;

import java.util.Collections;
import java.util.List;

public class UserMemoryCollectionRepo implements UserRepo {
    @Override
    public void add(User user) {
        user.setId(SequenceGenerator.getNextValue());
        userList.add(user);
    }

    @Override
    public void update(User user) {
        //
    }

    @Override
    public User findById(Long id) {
        return findUserById(id);
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
        User found = findUserById(id);

        if (found != null) {
            userList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    private User findUserById(long userId) {
        for (User user : userList) {
            if (Long.valueOf(userId).equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
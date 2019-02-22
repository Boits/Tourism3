package user.service;

import user.User;
import user.repo.UserMemoryRepo;

public class UserMemoryService {
    private UserMemoryRepo userMemoryRepo = new UserMemoryRepo();

    public void addUser(User user) {
        userMemoryRepo.addUser(user);
    }

    public void deleteUserByEntity(User user) {
        userMemoryRepo.deleteUserByEntity(user);
    }

    public void deleteUserByIndex(int index) {
        userMemoryRepo.deleteUserByIndex(index);
    }

    public void deleteUserByPassport(Integer passport) {
        userMemoryRepo.deleteUserByPassport(passport);
    }

    public User findUserByPassport(Integer passport) {
        return userMemoryRepo.findUserByPassport(passport);
    }

    public User findUserByLastName(String lastName) {
        return userMemoryRepo.findUserByLastName(lastName);
    }

    private Integer findUserIndexByEntity(User user) {
        return userMemoryRepo.findUserIndexByEntity(user);
    }

    public int sizeList() {
        return userMemoryRepo.sizeList();
    }

    public void printUsers() {
        userMemoryRepo.printUsers();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc_lingobridge;

public class UserStatistic {
    private final UserRepository userRepository;

    public UserStatistic(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserManagement checkUser(String username) {
        return userRepository.checkUser(username);
    }

    public void updateScore(UserManagement user) {
        userRepository.updateScore(user);
    }
}


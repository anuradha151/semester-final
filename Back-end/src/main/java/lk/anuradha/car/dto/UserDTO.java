package lk.anuradha.car.dto;

public class UserDTO {
    private int userId;
    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(int userId, String username, String password) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setPassword(password);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

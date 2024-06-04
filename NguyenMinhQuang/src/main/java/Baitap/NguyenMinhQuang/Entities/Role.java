package Baitap.NguyenMinhQuang.Entities;

public class Role {
    private int role_id;
    private int user_id;

    public Role(int role_id, int user_id) {
        this.role_id = role_id;
        this.role_id = user_id;
    }

    // Getter và setter cho role_id
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int role_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                "user_id=" + user_id +
                '}';
    }
}

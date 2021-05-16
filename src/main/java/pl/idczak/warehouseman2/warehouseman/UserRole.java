package pl.idczak.warehouseman2.warehouseman;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String description;
    @ManyToMany(mappedBy = "roles")
    private List<Warehouseman> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Warehouseman> getUsers() {
        return users;
    }

    public void setUsers(List<Warehouseman> users) {
        this.users = users;
    }
}

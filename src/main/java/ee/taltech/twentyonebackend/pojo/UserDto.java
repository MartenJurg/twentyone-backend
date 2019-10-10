package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.model.User;

public class UserDto {

    private Long id;
    private String name;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

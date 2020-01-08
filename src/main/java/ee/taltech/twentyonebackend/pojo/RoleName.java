package ee.taltech.twentyonebackend.pojo;

public enum  RoleName {
    ROLE_USER,
    ROLE_PM,
    ROLE_ADMIN;

    public String toSpringRole(){
        return "ROLE_" + this.name();
    }
}

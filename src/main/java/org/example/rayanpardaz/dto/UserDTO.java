package org.example.rayanpardaz.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonIgnore
    private int id;

    private String name;

    private String familyName;

    private String roleName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserDTO(int id, String name, String familyName, String roleName) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.roleName = roleName;
    }

    public static class UserDTOBuilder {
        private int id;

        private String name;

        private String familyName;

        private String roleName;

        public UserDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserDTOBuilder setFamilyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        public UserDTOBuilder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public UserDTO builder() {
            return new UserDTO(id, name, familyName, roleName);
        }
    }
}

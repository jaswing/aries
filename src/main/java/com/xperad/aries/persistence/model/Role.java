package com.xperad.aries.persistence.model;

import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Entity
@Table(name = "t_role")
public class Role extends BaseEntity implements Serializable {

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @Column(name = "role_name", length = 50)
    private String roleName;

    @OneToMany
    @JoinTable(name = "t_user_roles",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private Set<User> userRoles;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Role role = (Role) o;

        if (getRoleName() != null ? !getRoleName().equals(role.getRoleName()) : role.getRoleName() != null)
            return false;
        return !(getUserRoles() != null ? !getUserRoles().equals(role.getUserRoles()) : role.getUserRoles() != null);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getRoleName());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", super.getId())
                .append("roleName", this.getRoleName())
                .toString();
    }
}

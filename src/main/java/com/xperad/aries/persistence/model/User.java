package com.xperad.aries.persistence.model;

import com.google.common.base.Objects;
import com.xperad.aries.util.annotation.PasswordMatches;
import com.xperad.aries.util.annotation.ValidEmail;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Entity
@Table(name = "t_user")
@PasswordMatches
public class User extends BaseEntity implements UserDetails {

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @Column(name = "username", length = 50)
    private String username;

    //    @NotNull
//    @NotEmpty
    @Size(max = 50)
    @Column(name = "password", length = 50)
    private String password;
    @Transient
    private String matchingPassword;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "male")
    private boolean male;

    @Column(name = "date_info")
    private LocalDate dateInfo;

    @Column(name = "zoned_date_time1")
    private java.time.ZonedDateTime zonedDateTime1;

    @Column(name = "zoned_date_time2")
    private java.time.ZonedDateTime zonedDateTime2;

    @Column(name = "time_info")
    private LocalDateTime timeInfo;

    @ValidEmail
    @NotNull
    @NotEmpty
    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne
    @JoinTable(name = "t_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Role userRoles = this.getRole();
        if (userRoles != null) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRoles.getRoleName());
            authorities.add(authority);
        }
        return authorities;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return true = account is valid / not expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return true = account is not locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return true = password is valid / not expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (isEnabled() != user.isEnabled()) return false;
        if (isMale() != user.isMale()) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getMatchingPassword() != null ? !getMatchingPassword().equals(user.getMatchingPassword()) : user.getMatchingPassword() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getDateInfo() != null ? !getDateInfo().equals(user.getDateInfo()) : user.getDateInfo() != null)
            return false;
        if (getZonedDateTime1() != null ? !getZonedDateTime1().equals(user.getZonedDateTime1()) : user.getZonedDateTime1() != null)
            return false;
        if (getZonedDateTime2() != null ? !getZonedDateTime2().equals(user.getZonedDateTime2()) : user.getZonedDateTime2() != null)
            return false;
        if (getTimeInfo() != null ? !getTimeInfo().equals(user.getTimeInfo()) : user.getTimeInfo() != null)
            return false;
        if (getEmailAddress() != null ? !getEmailAddress().equals(user.getEmailAddress()) : user.getEmailAddress() != null)
            return false;
        return !(getRole() != null ? !getRole().equals(user.getRole()) : user.getRole() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getMatchingPassword() != null ? getMatchingPassword().hashCode() : 0);
        result = 31 * result + (isEnabled() ? 1 : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (isMale() ? 1 : 0);
        result = 31 * result + (getDateInfo() != null ? getDateInfo().hashCode() : 0);
        result = 31 * result + (getZonedDateTime1() != null ? getZonedDateTime1().hashCode() : 0);
        result = 31 * result + (getZonedDateTime2() != null ? getZonedDateTime2().hashCode() : 0);
        result = 31 * result + (getTimeInfo() != null ? getTimeInfo().hashCode() : 0);
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }

    public ZonedDateTime getZonedDateTime1() {
        return zonedDateTime1;
    }

    public void setZonedDateTime1(ZonedDateTime zonedDateTime1) {
        this.zonedDateTime1 = zonedDateTime1;
    }

    public ZonedDateTime getZonedDateTime2() {
        return zonedDateTime2;
    }

    public void setZonedDateTime2(ZonedDateTime zonedDateTime2) {
        this.zonedDateTime2 = zonedDateTime2;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public LocalDate getDateInfo() {

        return dateInfo;
    }

    public void setDateInfo(LocalDate dateInfo) {
        this.dateInfo = dateInfo;
    }

    public LocalDateTime getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(LocalDateTime timeInfo) {
        this.timeInfo = timeInfo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /*@Override
    public int hashCode() {
        return Objects.hashCode(getId(), getUsername(), getPassword(), getRole().getRoleName(), isEnabled(), getEmailAddress(), getFirstName(), getLastName(), getTimeInfo());
    }*/

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", super.getId())
                .append("username", this.getUsername())
                .append("password", this.getPassword())
                .append("enabled", this.isEnabled())
                .append("dateInfo", this.getDateInfo())
                .append("timeInfo", this.getTimeInfo())
                .append("zoneDateTimeInfo1", this.getZonedDateTime1())
                .append("zoneDateTimeInfo2", this.getZonedDateTime2())
                .append("role", getRole().getRoleName())
                .toString();
    }
}

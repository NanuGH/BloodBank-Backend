package cv.hernani.bloodbankprojectspring.configs;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalhEmployeeData implements UserDetails {

    private final Optional<EmployeeModel> employee;

    public DetalhEmployeeData(Optional<EmployeeModel> employee) {
        this.employee = employee;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return employee.orElse(new EmployeeModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return employee.orElse(new EmployeeModel()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

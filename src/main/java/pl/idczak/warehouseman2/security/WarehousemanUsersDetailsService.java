package pl.idczak.warehouseman2.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.idczak.warehouseman2.warehouseman.UserRole;
import pl.idczak.warehouseman2.warehouseman.Warehouseman;
import pl.idczak.warehouseman2.warehouseman.WarehousemanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WarehousemanUsersDetailsService implements UserDetailsService {

    private WarehousemanRepository warehousemanRepository;

    public WarehousemanUsersDetailsService(WarehousemanRepository warehousemanRepository) {
        this.warehousemanRepository = warehousemanRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Warehouseman> optional = warehousemanRepository.findByName(name);
        optional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Warehouseman warehouseman = optional.get();
        return new User(warehouseman.getName(), warehouseman.getPassword(), convertAuthority(warehouseman.getRoles()));
    }

    private List<GrantedAuthority> convertAuthority(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
}

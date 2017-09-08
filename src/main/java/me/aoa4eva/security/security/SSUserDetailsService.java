package me.aoa4eva.security.security;

import me.aoa4eva.security.models.RoleClass;
import me.aoa4eva.security.models.Student;
import me.aoa4eva.security.repositories.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {

    private StudentRepository userRepository;

    public SSUserDetailsService(StudentRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try {
              Student student = userRepository.findByUsername(username);
              if(student==null)
              {
                  System.out.println("Unable to find user");
                  return null;
              }
              return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getPassword(),getAuthorities(student));
        }catch(Exception e)
        {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(Student student){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(RoleClass roleClass:student.getRoles())
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleClass.getRole());
            authorities.add(grantedAuthority);
        }
        System.out.println("user authorities are "+authorities.toString());
        return authorities;

    }

}

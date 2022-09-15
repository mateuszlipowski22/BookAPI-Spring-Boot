package pl.coderslab.bookapispringboot.models;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private final pl.coderslab.bookapispringboot.models.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.bookapispringboot.models.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.coderslab.bookapispringboot.models.User getUser() {return user;}
}

package ec.edu.espam.api.caja.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends Person {

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private Boolean state;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;
}

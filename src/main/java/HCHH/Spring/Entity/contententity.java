package HCHH.Spring.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class contententity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String content;

    public Long getID() {
        return id;
    }
}

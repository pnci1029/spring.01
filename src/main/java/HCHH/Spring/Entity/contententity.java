package HCHH.Spring.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class contententity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private String content;

    public Long getID() {
        return id;
    }
}

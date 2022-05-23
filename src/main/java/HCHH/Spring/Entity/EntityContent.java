package HCHH.Spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityContent {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private String content;

    public EntityContent(Long id, String username, String content) {
        this.id = id;
        this.username = username;
        this.content = content;
    }


    @Override
    public String toString() {
        return "EntityContent{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

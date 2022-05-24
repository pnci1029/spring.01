package HCHH.Spring.DTO;

import HCHH.Spring.Entity.contententity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class contentdto {
    private String username;
    private String content;


    public contententity toEntity() {

        return new contententity(null, username, content);
    }
}

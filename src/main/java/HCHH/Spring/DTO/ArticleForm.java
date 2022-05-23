package HCHH.Spring.DTO;

import HCHH.Spring.Entity.EntityContent;

public class ArticleForm {

    private String username;
    private String content;

    public ArticleForm(String username, String content) {
        this.username = username;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public EntityContent toEntity() {

        return new EntityContent(null, username, content);
    }
}

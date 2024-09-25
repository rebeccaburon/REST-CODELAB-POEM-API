package dat.dtos;

import dat.entities.Poem;
import dat.enums.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PoemDTO {

    private long id;
    private String author;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String poem;

    public PoemDTO (Poem poem){
        this.id = poem.getId();
        this.author = poem.getAuthor();
        this.type = poem.getType();
        this.poem = poem.getPoem();
    }
}

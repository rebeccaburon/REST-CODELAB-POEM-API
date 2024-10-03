package dat.dtos;

import dat.entities.Poem;
import dat.enums.Type;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PoemDTO {

    private long id;
    private String author;
    private Type type;
    private String poem;

    public PoemDTO (Poem poem){
        this.id = poem.getId();
        this.author = poem.getAuthor();
        this.type = poem.getType();
        this.poem = poem.getPoem();
    }

    public static List<PoemDTO> toDTOList(List<Poem> poems){
        return poems.stream().map(PoemDTO::new).toList();
    }

}

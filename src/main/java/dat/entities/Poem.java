package dat.entities;

import dat.dtos.PoemDTO;
import dat.enums.Type;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name="author", length = 50, nullable = false)
    private String author;
    @Column(name="poem", length = 1000, nullable = false)
    private String poem;
    @Enumerated(EnumType.STRING)
    @Column(name="type", length = 30, nullable = false)
    private Type type;
    
    public Poem (PoemDTO poemDTO){
    this.author = poemDTO.getAuthor();
    this.type = poemDTO.getType();
    this.poem = poemDTO.getPoem();
    }
}

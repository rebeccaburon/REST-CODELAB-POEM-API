package dat.entities;

import dat.dtos.PoemDTO;
import dat.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Poem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id",nullable = false, unique = true)
    private long id;
    @Column(name="author", nullable = false)
    private String author;
    @Enumerated(EnumType.STRING)
    @Column(name="type",nullable = false)
    private Type type;
    private String poem;
    
    public Poem (PoemDTO poemDTO){
    this.author = poemDTO.getAuthor();
    this.type = poemDTO.getType();
    this.poem = poemDTO.getPoem();
    }
}

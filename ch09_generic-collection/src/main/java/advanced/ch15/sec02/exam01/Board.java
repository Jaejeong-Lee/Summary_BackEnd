package advanced.ch15.sec02.exam01;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Board {
    private String subject;
    private String content;
    private String writer;

}
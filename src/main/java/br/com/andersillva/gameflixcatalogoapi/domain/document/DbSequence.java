package br.com.andersillva.gameflixcatalogoapi.domain.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "db_sequences")
public class DbSequence {

    @Id
    private String id;

    private Long sequence;

}

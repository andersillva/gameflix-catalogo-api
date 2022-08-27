package br.com.andersillva.gameflixcatalogoapi.domain.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import br.com.andersillva.gameflixcatalogoapi.domain.document.DbSequence;

@Service
public class GeradorIdServiceImpl implements GeradorIdService {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public Long gerarId(String sequenceName) {

		Query query = new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("sequence", 1);
	
        DbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequence.class);

        return !Objects.isNull(counter) ? counter.getSequence() : 1;

	}

}

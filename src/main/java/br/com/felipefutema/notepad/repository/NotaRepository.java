package br.com.felipefutema.notepad.repository;

import br.com.felipefutema.notepad.model.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String>{

    public List<Nota> findByTitulo(String titulo);

}

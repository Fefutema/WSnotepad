package br.com.felipefutema.notepad.service;

import br.com.felipefutema.notepad.model.Nota;
import br.com.felipefutema.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public void salvar(Nota nota){
        List<Nota> notas =  notaRepository.findByTitulo(nota.getTitulo());

        if(notas != null && !notas.isEmpty()){
            nota.setId(notas.get(0).getId());
        }

        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo) {
        List<Nota> notas =  notaRepository.findByTitulo(titulo);

        if(notas != null && !notas.isEmpty()){
            return notas.get(0);
        }else {
            return new Nota();
        }

    }

}

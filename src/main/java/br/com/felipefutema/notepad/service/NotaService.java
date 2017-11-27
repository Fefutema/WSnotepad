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
        Nota notaR =  notaRepository.findByTitulo(nota.getTitulo());

        if(notaR != null && !notaR.getId().equalsIgnoreCase("")){
            nota.setId(notaR.getId());
        }

        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo) {
        Nota notaR =  notaRepository.findByTitulo(titulo);

        if(notaR != null && !notaR.getId().equalsIgnoreCase("")){
            return notaR;
        }else {
            return new Nota();
        }

    }

}

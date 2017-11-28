package br.com.felipefutema.notepad.controller;

import br.com.felipefutema.notepad.model.Nota;
import br.com.felipefutema.notepad.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    NotaService notaService;

    @GetMapping
    public List<Nota> buscarTodos(){
        return notaService.buscarTodas();
    }

    @GetMapping("/titulo/{titulo}")
    public Nota buscar(@PathVariable("titulo") String titulo) {
        return notaService.buscar(titulo);
    }

    @PostMapping
    public void salvar(@RequestBody Nota nota){
        notaService.salvar(nota);
    }

    @DeleteMapping("/titulo/{titulo}")
    public void excluir(@PathVariable("titulo") String titulo){
        notaService.excluir(titulo);
    }

}

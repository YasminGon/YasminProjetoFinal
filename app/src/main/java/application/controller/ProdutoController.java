package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Produto;
import application.model.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("produtos", produtoRepo.findAll());
        return "/produto/list";
    }
    @RequestMapping("/insert")
    public String insert() {
        return "/produto/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo, 
        @RequestParam("descricao") String descricao) {
        Produto produto = new Produto();
        produto.setTitulo(titulo);
        produto.setDescricao(descricao);

        produtoRepo.save(produto);
        return "redirect:/produto/list";
        }
    
    @RequestMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Produto> produto= produtoRepo.findById(id);

        if(produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            return "/produto/update";
        }

        return "redirect:/produto/list";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") int id,
        @RequestParam("titulo") String titulo,
        @RequestParam("descricao") String descricao) {
    
        Optional<Produto> produto= produtoRepo.findById(id);

        if(produto.isPresent()) {
            produto.get().setTitulo(titulo);       
            produto.get().setDescricao(descricao);

            produtoRepo.save(produto.get());
        }
        return "redirect:/produto/list";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Produto> produto= produtoRepo.findById(id);

        if(produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            return "/produto/delete";
        }

        return "redirect:/produto/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id ) {
        produtoRepo.deleteById(id);

        return "redirect:/produto/list";
    }
}


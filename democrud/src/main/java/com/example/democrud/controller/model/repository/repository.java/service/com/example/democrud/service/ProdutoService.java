package com.example.democrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democrud.model.Produto;
import com.example.democrud.repository.ProdutoRepository;

@Service 
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(String id) {
        // Busca um registro pelo ID no banco de dados.
        return produtoRepository.findById(id);
    }

    public Produto save(Produto model) {
        return produtoRepository.save(model);
    }

    public boolean deleteById(String id) {
        if (produtoRepository.findById(id).isPresent()) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Produto> update(String id, Produto updatedModel) {
        return produtoRepository.findById(id).map(existingModel -> {
            existingModel.setName(updatedModel.getName());
            existingModel.setDescription(updatedModel.getDescription()); 
            return produtoRepository.save(existingModel); 
        });
    }

    public List<Produto> findByName(String name) {
        return produtoRepository.findByName(name);
    }

    public List<Produto> findByDescription(String description) {
        return produtoRepository.findByDescription(description);
    }
}
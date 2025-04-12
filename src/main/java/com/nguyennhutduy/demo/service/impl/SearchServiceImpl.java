package com.nguyennhutduy.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nguyennhutduy.demo.entity.Search;
import com.nguyennhutduy.demo.repository.SearchRepository;
import com.nguyennhutduy.demo.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
    private final SearchRepository searchRepository;

    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public Search createSearch(Search search) {
        return searchRepository.save(search);
    }

    @Override
    public Search getSearchById(Long searchId) {
        return searchRepository.findById(
                searchId)
                .orElseThrow(() -> new RuntimeException("Search with ID " + searchId + " not found"));
    }

    @Override
    public List<Search> getAllSearch() {
        return searchRepository.findAll();
    }

    @Override
    public Search updateSearch(Search search) {
        Search existingSearch = searchRepository.findById(search.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (search.getUser() != null && !search.getUser().equals(existingSearch.getUser())) {
            existingSearch.setUser(search.getUser());
        }
        if (search.getKeyword() != null && !search.getKeyword().equals(existingSearch.getKeyword())) {
            existingSearch.setKeyword(search.getKeyword());
        }
        return searchRepository.save(existingSearch);
    }

    @Override
    public void deleteSearch(Long searchId) {
        if (!searchRepository.existsById(searchId)) {
            throw new RuntimeException("Search with ID " + searchId + " not found");
        }
        searchRepository.deleteById(searchId);
    }

}

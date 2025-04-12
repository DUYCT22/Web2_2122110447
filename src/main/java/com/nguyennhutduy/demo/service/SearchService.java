package com.nguyennhutduy.demo.service;

import java.util.List;

import com.nguyennhutduy.demo.entity.Search;

public interface SearchService {
    Search createSearch(Search search);

    Search getSearchById(Long searchId);

    List<Search> getAllSearch();

    Search updateSearch(Search search);

    void deleteSearch(Long searchId);
}

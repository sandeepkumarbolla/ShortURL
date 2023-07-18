package com.example.URL_shortner.repo;

import com.example.URL_shortner.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface URLRepo extends JpaRepository<Link, String> {

    @Query(nativeQuery = true,value = "SELECT url FROM urls where shurl=:shurl")
    public Optional<String> findbyshurl(String shurl);

    @Query(nativeQuery = true,value = "SELECT * FROM urls where shurl=:shurl")
    public Link findobjbyshurl(String shurl);
}

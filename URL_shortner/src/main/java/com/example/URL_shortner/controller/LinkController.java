package com.example.URL_shortner.controller;

import com.example.URL_shortner.model.Link;
import com.example.URL_shortner.repo.URLRepo;
import com.example.URL_shortner.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class LinkController {
    @Autowired
    LinkService linkService;
    @Autowired
    URLRepo urlRepo;
    Link link;
    @GetMapping("/links")
    public List<Link> getLinks(){
        return urlRepo.findAll();
    }
    @PostMapping("/addurl")
    public ResponseEntity<String> addURL(@RequestBody Link link) {
        List<Link> links = urlRepo.findAll();
        List<String> urls = links.stream()
                        .map(Link::getUrl)
                        .toList();
        String str;
        if (urls.contains(link.getUrl())) {
            return ResponseEntity.status(HttpStatus.OK).body("Short url for this URL already exists!");
        } else {
            //sets current date and time with addition of 5 minutes
            link.setDate(LocalDateTime.now().plusMinutes(5));

            //generates random string with 5 letters
            str = linkService.RandomStringGenerator();
            //extracts the current shortURLs from the table and stores in the list
            List<String> urlinLinks = links
                    .stream()
                    .map(Link::getShurl)
                    .toList();
            //checks whether newly generated string exists in the list of shortURLs
            while (urlinLinks.contains(str)) {
                //if yes it generates again new string and stores it in str
                str = linkService.RandomStringGenerator();
            }
            //sets short url to the link object
            link.setShurl(str);
            urlRepo.save(link);
        }
        return ResponseEntity.status(HttpStatus.OK).body("short URL created->> http://localhost:8080/" + str);
    }
    @GetMapping(value = "/{shurl}")
    public ResponseEntity<String> redirect(@PathVariable String shurl){
        Optional<String> url = urlRepo.findbyshurl(shurl);
        if (url.isPresent()){
            Link link1 = urlRepo.findobjbyshurl(shurl);
            System.out.println(url.get());
            System.out.println();

            if (link1.getDate().isAfter(LocalDateTime.now())){
                System.out.println("redirected to the original link");
                return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://"+url.get())).build();
            }
            else{
                System.out.println("link expired");
                return ResponseEntity.status(HttpStatus.OK).body("link expired create a new Short URL @ http://192.168.50.81:3000/ ");
            }
        }
        else {
            //return ResponseEntity.status(HttpStatus.OK).body("link not available create a new one!!! ");
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://192.168.50.81:3000/")).build();
        }
    }
}

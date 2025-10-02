package com.estudando.dddworkshopmongo.resources;

import com.estudando.dddworkshopmongo.domain.Post;
import com.estudando.dddworkshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;

import static java.net.URL.setURLStreamHandlerFactory;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(value="/titlesearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        text = URLDecoder.decode(text, Charset.defaultCharset());
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}

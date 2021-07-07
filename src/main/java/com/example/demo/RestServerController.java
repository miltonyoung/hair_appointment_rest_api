package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestServerController
{
    @GetMapping("/test")
    public ResponseEntity testResource()
    {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(123)
                .toUri();

        List list = new ArrayList();
        Map r = new HashMap<>();
        r.put("test-key", 123);
        r.put("uri", uri);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uri);
//        responseHeaders.set("MyResponseHeader", "MyValue");
        list.add(r);
        return new ResponseEntity<List>(list, responseHeaders, HttpStatus.CREATED);
    }

}

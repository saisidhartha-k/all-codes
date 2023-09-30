package com.learn.server.controller;

import java.io.IOException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.server.entity.Server;
import com.learn.server.service.serverService;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"})

@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private serverService serverService;

    @GetMapping("/status")
    public String getStatus() {
        return "works";
    }

    @PostMapping("/create")
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server createdServer = serverService.create(server);
        return new ResponseEntity<>(createdServer, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Server> getServer(@PathVariable int id) {
        Server server = serverService.get(id);
        if (server != null) {
            return new ResponseEntity<>(server, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Server> updateServer(@PathVariable int id, @RequestBody Server server) {
        server.setId(id); 
        Server updatedServer = serverService.update(server);
        return new ResponseEntity<>(updatedServer, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable int id) {
        boolean deleted = serverService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<java.util.Collection<Server>> listServers(@RequestParam(defaultValue = "10") int limit) {
        java.util.Collection<Server> servers = serverService.list(limit);
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @GetMapping("/ping/{id}")
    public ResponseEntity<Server> pingServer(@PathVariable("id") int id) {
        try {
            Server server = serverService.ping(id);
            return ResponseEntity.ok(server);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

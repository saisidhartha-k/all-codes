package com.learn.server.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.learn.server.entity.Server;
import com.learn.server.entity.Status;
import com.learn.server.repository.serverRepository;
import com.learn.server.service.implementations.serverInterface;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class serverService implements serverInterface {

    @Autowired
    private serverRepository serverrepository;

    @Override
    public Server create(Server server) {
        log.info("new server", server.getName());
        return serverrepository.save(server);
    }

    @Override
    public Server ping(int id) throws IOException {
        log.info("pinging the server", id);
        Server server = serverrepository.findById(id).get();

        server.setStatus(server.getStatus() == Status.SERVER_DOWN ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverrepository.save(server);
        // Server server2 = serverrepository.findByName("server1");
        return server;
    }

    @Override
    public Server get(int id) {
        log.info("getting the server");
        Optional<Server> serverTemp = serverrepository.findById(id);
        Server server = serverTemp.get();
        return server;

    }

    @Override
    public Server update(Server server) {
        log.info("update", server.getName());
        return serverrepository.save(server);
    }

    @Override
    public boolean delete(int id) {
        log.info("deleteing");
        serverrepository.deleteById(id);
        return serverrepository.findById(id).isPresent();
    }

    @Override
    public java.util.Collection<Server> list(int limit) {
        log.info("getting the servers");
        return serverrepository.findAll(PageRequest.of(0, limit)).toList();
    }

}

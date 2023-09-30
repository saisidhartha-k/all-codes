package com.learn.server.service.implementations;

import java.io.IOException;
import java.util.Collection;

import com.learn.server.entity.Server;

public interface serverInterface {

    Server create(Server server);

    Server ping(int id) throws IOException;

    Server get(int id);

    Server update(Server server);

    boolean delete(int id);

    Collection<Server> list(int limit);
}

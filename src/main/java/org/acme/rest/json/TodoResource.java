package org.acme.rest.json;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.entities.Todo;

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    private Set<Todo> todos = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public TodoResource() {
        todos.add(new Todo(1, "Hello my todo", false, false, new Date(), new Date()));
        todos.add(new Todo(2, "Hello my todo", false, false, new Date(), new Date()));
        todos.add(new Todo(3, "Hello my todo", false, false, new Date(), new Date()));
        todos.add(new Todo(4, "Hello my todo", false, false, new Date(), new Date()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(todos).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getTodo(@PathParam("id") int id) {
        for (Iterator<Todo> it = todos.iterator(); it.hasNext();) {
            Todo t = it.next();

            if (t.getId() == id) {
                return Response.ok(t).build();
            }
        }

        return Response.status(400).entity("TODO_NOT_EXIST").build();
    }

    @POST
    public Response add(Todo todo) {
        todos.add(todo);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Todo todo) {
        for (Iterator<Todo> it = todos.iterator(); it.hasNext();) {
            Todo t = it.next();

            if (t.equals(todo)) {
                t.setComplete(todo.getComplete());
                return Response.ok(t).build();
            }
        }

        return Response.status(400, "INVALID_TODO").build();
    }
}
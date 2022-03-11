package com.example.RESTWebService.api;

import com.example.RESTWebService.dao.DAOService;
import com.example.RESTWebService.exception.UserNotFoundException;
import com.example.RESTWebService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController
{
    @Autowired
    DAOService UserDAOService;

    //@Valid
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user)
    {
        User createdUser = UserDAOService.saveUser(user);

        //return location and id of created user
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/getAllUsers")
    public List<User> getAllUsers()
    {
        return UserDAOService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id)
    {
        User foundUser = UserDAOService.findUser(id);
        if(foundUser==null)
            throw new UserNotFoundException("id-"+id);

        //HATEOAS

        //1. create a User resource to return
        EntityModel<User> resource = EntityModel.of(foundUser);

        //2. get a link to the getAllUsers() method
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());

        //3. add link to resource to return
        resource.add(linkTo.withRel("getAllUsers"));

        return resource;
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id)
    {
        User user = UserDAOService.deleteUserById(id);
        if(user==null)
            throw new UserNotFoundException("id " + id);
    }


}

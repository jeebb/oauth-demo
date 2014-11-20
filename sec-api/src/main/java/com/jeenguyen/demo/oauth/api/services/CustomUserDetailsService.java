package com.jeenguyen.demo.oauth.api.services;

import com.jeenguyen.demo.oauth.api.entities.MongoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by jeebb on 11/8/14.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        MongoUser user =
                mongoTemplate.findOne(query, MongoUser.class);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        }

        String[] roles = new String[user.getRoles().size()];

        return new User(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoles().toArray(roles)));
    }
}

package com.absolute.daytracker.ws.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.absolute.daytracker.ws.domain.User;

public class UserDaoHibernateImpl extends HibernateDaoSupport implements UserDao {

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByLogin(String login) {
        List<User> result = getHibernateTemplate().find(
            "from User u left join fetch u.roles where u.login = ?", login
        );
        return ((result == null) || (result.size() == 0)) ? null : result.get(0);
    }

    @Override
    public User getUserById(Long id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public User createUser(User user) {
        // If a challengeRequest exists, change the user's challenge to it.  Otherwise,
        // we let the problem bubble up as an exception (because the challenge property
        // cannot be null).
        user.setChallenge(user.getChallengeRequest());

        getHibernateTemplate().save(user);
        return user;
    }

    @Override
    public User createOrUpdateUser(User user) {
        // If a challengeRequest exists, change the user's password to it.  Otherwise
        // keep the challenge the same.
        String currentChallenge = (String)(getHibernateTemplate()
                .find("select challenge from User where id = ?", user.getId()).get(0));

        user.setChallenge(user.getChallengeRequest() != null ?
                user.getChallengeRequest() : currentChallenge);

        // We must perform a merge instead of saveOrUpdate so that child collections will
        // "sync" correctly, including deletions.
        //
        // This is particularly important if the incoming User object is detached,
        // or created outside of Hibernate (e.g., delivered over the network).
        return getHibernateTemplate().merge(user);
    }

}

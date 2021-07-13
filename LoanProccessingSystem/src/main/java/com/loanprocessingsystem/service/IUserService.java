package com.loanprocessingsystem.service;

import com.loanprocessingsystem.entities.User;

/* User Service 
 * IUserServiceImpl implements IUserService 
 * User addNewUser(User user) to add new user as admin,customer,loanmanager.
 * User signIn(User user) to sign in
 * User signOut(User user) to sign out
 */


public interface IUserService  {
public  User addNewUser(User user);
public  User signIn(User user);
public  User signOut(User user);

}

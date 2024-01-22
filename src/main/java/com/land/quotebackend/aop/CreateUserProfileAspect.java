package com.land.quotebackend.aop;

import com.land.quotebackend.entity.User;
import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.service.UserProfileService;
import com.land.quotebackend.service.UserService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CreateUserProfileAspect {

    private final UserProfileService _userProfileService;

    public CreateUserProfileAspect(UserProfileService userProfileService) {
        _userProfileService = userProfileService;
    }

    @Pointcut("execution(* com.land.quotebackend.service.impl.UserServiceImpl.saveUser(..))")
    public void saveUserMethod() {

    }

    @AfterReturning(pointcut = "saveUserMethod()", returning = "returnValue")
    public void createUserProfileAfterUserSaved(Object returnValue){
        if(returnValue instanceof User user){
            UserProfile userProfile = new UserProfile(null,null,null,null,user,null);
            _userProfileService.createUserProfile(userProfile);
        }
    }
}

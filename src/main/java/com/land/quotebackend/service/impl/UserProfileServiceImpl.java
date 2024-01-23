package com.land.quotebackend.service.impl;

import com.land.quotebackend.entity.UserProfile;
import com.land.quotebackend.excepiton.UserProfileNotFoundException;
import com.land.quotebackend.repository.UserProfileRepository;
import com.land.quotebackend.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository _userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        _userProfileRepository = userProfileRepository;
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return _userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserProfileById(String id) {
        var userProfile = _userProfileRepository.findById(id).orElseThrow(() -> new UserProfileNotFoundException(String.format("User profile not found with id: %s", id)));
        return  userProfile;
    }

    @Override
    public void createUserProfile(UserProfile userProfile) {
        _userProfileRepository.save(userProfile);
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        if (_userProfileRepository.existsById(userProfile.getUserId())) {
            _userProfileRepository.save(userProfile);
            return;
        }
        throw new UserProfileNotFoundException("User profile not updated with id: " + userProfile.getUserId());
    }

    @Override
    public void deleteUserProfileById(String id) {
        _userProfileRepository.deleteById(id);
    }
}

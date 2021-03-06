package gr.uoa.di.rent.services;


import gr.uoa.di.rent.models.Profile;
import gr.uoa.di.rent.repositories.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public int updateUserProfile(Profile profile) {

        return profileRepository.updateProfile(profile.getOwner_id(), profile.getName(), profile.getSurname(), profile.getBirthday(), profile.getPhoto_url());
    }
}

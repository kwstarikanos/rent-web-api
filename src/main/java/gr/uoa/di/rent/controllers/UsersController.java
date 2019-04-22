package gr.uoa.di.rent.controllers;

import gr.uoa.di.rent.exceptions.AppException;
import gr.uoa.di.rent.exceptions.NotAuthorizedException;
import gr.uoa.di.rent.models.User;
import gr.uoa.di.rent.payload.requests.UserUpdateRequest;
import gr.uoa.di.rent.repositories.UserRepository;
import gr.uoa.di.rent.security.CurrentUser;
import gr.uoa.di.rent.security.UserDetailsImpl;
import gr.uoa.di.rent.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/users")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("")
    //@PreAuthorize("hasRole('ADMIN')")        //this doesnt work
    @PreAuthorize("hasAuthority('ADMIN')") //this works !!
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/lockUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Resource> lockUsers(@RequestParam("userIDs") List<Long> userIDs, @Valid @CurrentUser UserDetailsImpl currentUser) {

        //logger.debug("UserIDs: " + userIDs.toString());

        // Make sure the admin will NOT get locked by mistake!
        userIDs.remove(currentUser.getId());

        int changed = userRepository.lockUsers(userIDs);

        return handleUsersUpdateResponse(changed, userIDs, "locked");
    }


    @PostMapping("/unlockUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Resource> unlockUsers(@RequestParam("userIDs") List<Long> userIDs) {

        //logger.debug("UserIDs: " + userIDs.toString());

        int changed = userRepository.unlockUsers(userIDs);

        return handleUsersUpdateResponse(changed, userIDs, "unlocked");
    }


    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> updateUserInfo(@PathVariable(value = "userId") Long userId,
                                            @Valid @RequestBody UserUpdateRequest userUpdateRequest,
                                            @Valid @CurrentUser UserDetailsImpl currentUser) {

        if ( !currentUser.getId().equals(userId) ) {
            throw new NotAuthorizedException("You are not authorized to create this resource.");
        }

        User user = userUpdateRequest.asUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));   // Encrypt the password
        user.setId(currentUser.getId());    // Set the id.

        //logger.debug(user.toString());

        int affectedRows = this.userService.updateUserData(user);
        if ( affectedRows == 1 ) {
            logger.debug("User info was updated for user with id: " + userId);
            return ResponseEntity.ok().build();
        }
        else {
            logger.warn("No user was found in DataBase having userId: " + userId);
            return ResponseEntity.badRequest().build();
        }
    }


    private ResponseEntity<Resource> handleUsersUpdateResponse(int changed, List<Long> userIDs, String operation) {

        String errorMsg;
        if ( changed == 0 ) {
            errorMsg = "No users were " + operation + "!";
            logger.error(errorMsg);
            throw new AppException(errorMsg);
        }
        else if ( changed != userIDs.size() ) {
            errorMsg = "Operation unsuccessful: "  + (userIDs.size() - changed) + " users were not" + operation + "!";
            logger.error(errorMsg);
            throw new AppException(errorMsg);
        }
        else
            return ResponseEntity.ok().build();
    }

}

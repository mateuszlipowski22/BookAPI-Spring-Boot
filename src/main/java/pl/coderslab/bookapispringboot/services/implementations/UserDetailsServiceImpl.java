package pl.coderslab.bookapispringboot.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.bookapispringboot.models.UserDetails;
import pl.coderslab.bookapispringboot.repositories.UserDetailsRepository;
import pl.coderslab.bookapispringboot.services.UserDetailsService;

import java.io.IOException;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void saveUserDetails(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails getUserDetails(Long userId) {
        return userDetailsRepository.findByUserId(userId);
    }

    @Override
    public void saveImageFile(Long userId, MultipartFile file){
        try{
            UserDetails userDetailsDB = userDetailsRepository.findByUserId(userId);
            Byte[] byteObject = new Byte[file.getBytes().length];
            int i=0;

            for (byte b : file.getBytes()){
                byteObject[i++]=b;
            }
            userDetailsDB.setImage(byteObject);
            userDetailsRepository.save(userDetailsDB);;
        }catch (IOException e){
            log.error("Error occurred", e);
            e.printStackTrace();
        }
    }

}

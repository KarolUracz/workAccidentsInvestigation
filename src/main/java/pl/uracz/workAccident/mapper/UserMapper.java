package pl.uracz.workAccident.mapper;

import org.mapstruct.Mapper;
import pl.uracz.workAccident.dto.UserAuthDto;
import pl.uracz.workAccident.dto.UserRegisterDto;
import pl.uracz.workAccident.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRegisterDto userToUserRegistrationDto (User user);
    User userRegistrationDtoToUser(UserRegisterDto userRegisterDto);
    UserAuthDto userToUserAuthDto(User user);
    User authDtoToUser(UserAuthDto userAuthDto);
}

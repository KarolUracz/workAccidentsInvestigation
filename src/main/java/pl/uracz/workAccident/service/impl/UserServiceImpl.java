package pl.uracz.workAccident.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.uracz.workAccident.dto.UserRegisterDto;
import pl.uracz.workAccident.entity.Company;
import pl.uracz.workAccident.entity.Role;
import pl.uracz.workAccident.entity.User;
import pl.uracz.workAccident.mapper.CompanyMapper;
import pl.uracz.workAccident.mapper.UserMapper;
import pl.uracz.workAccident.repository.CompanyRepository;
import pl.uracz.workAccident.repository.RoleRepository;
import pl.uracz.workAccident.repository.UserRepository;
import pl.uracz.workAccident.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private CompanyRepository companyRepository;
    private UserMapper userMapper;
    private CompanyMapper companyMapper;

    public UserServiceImpl(UserRepository userRepository, @Lazy BCryptPasswordEncoder passwordEncoder,
                           RoleRepository roleRepository, CompanyRepository companyRepository,
                           UserMapper userMapper, CompanyMapper companyMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.companyRepository = companyRepository;
        this.userMapper = userMapper;
        this.companyMapper = companyMapper;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User readUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveUser(UserRegisterDto userRegisterDto) {
        User user = userMapper.userRegistrationDtoToUser(userRegisterDto);

//        user.setUsername(userRegisterDto.getUsername());
//        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        Company company = companyMapper.companyDtoToCompany(userRegisterDto.getCompanyDto());
        companyRepository.save(company);
        user.setCompany(company);
        userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}

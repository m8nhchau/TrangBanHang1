package com.example.trangbanhangonline.repository.user;

import com.example.trangbanhangonline.dto.requestDTO.user.UserRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.user.UserResponseDTO;
import com.example.trangbanhangonline.entity.User;
import com.example.trangbanhangonline.mapper.user.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryEM {
    private final EntityManager entityManager;
    private final UsersMapper usersMapper;

    public List<UserResponseDTO> findByCondition(UserRequestDTO userRequestDTO){
        List<User> users;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if (userRequestDTO.getFullName() != null){
            predicates.add(cb.like(root.get("fullName"), "%" + userRequestDTO.getFullName()+"%"));
        }
        if (userRequestDTO.getUserName() != null){
            predicates.add(cb.like(root.get("userName"), "%" + userRequestDTO.getUserName()+"%"));
        }
        if (userRequestDTO.getAddress() != null){
            predicates.add(cb.like(root.get("address"), "%" + userRequestDTO.getAddress()+"%"));
        }
        if (userRequestDTO.getBirthday() != null){
            Expression<Date> convertFunction = cb.function("DATE", Date.class, root.get("birthday"));
            predicates.add(cb.equal(convertFunction, userRequestDTO.getBirthday()));
        }

        TypedQuery<User> query = entityManager.createQuery(cq.select(root).distinct(true)
                .where(cb.and(predicates.toArray(new Predicate[]{}))));

        users = query.getResultList();

        return usersMapper.toResponseUserList(users);

    }

}

package com.example.trangbanhangonline.repository.order;

import com.example.trangbanhangonline.dto.requestDTO.order.OrderRequestDTO;
import com.example.trangbanhangonline.dto.responseDTO.order.OrderResponseDTO;
import com.example.trangbanhangonline.entity.Orders;
import com.example.trangbanhangonline.enums.OrderStatusEnum;
import com.example.trangbanhangonline.mapper.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryEM {
    private final EntityManager entityManager;
    private final OrderMapper orderMapper;

    public List<OrderResponseDTO> findCondition(OrderRequestDTO orderRequestDTO) throws ParseException {
        List<Orders> orders;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Orders> cq = cb.createQuery(Orders.class);
        Root<Orders> root = cq.from(Orders.class);
        List<Predicate> predicates = new ArrayList<>();

        if (orderRequestDTO.getUserId() != null){
//            Join<Orders, User> userJoin = root.join("user", JoinType.LEFT);
            //predicates.add(cb.equal(userJoin.get("userId"), orderRequestDTO.getUserId()));
            predicates.add(cb.equal(root.get("user").get("userId"), orderRequestDTO.getUserId()));
        }
        if (orderRequestDTO.getFullName() != null){
            predicates.add(cb.like(root.get("user").get("fullName"), "%" + orderRequestDTO.getFullName()+"%"));
        }
        if (orderRequestDTO.getStatus() != null){
            OrderStatusEnum orderStatusEnum = OrderStatusEnum.numberToEnum(orderRequestDTO.getStatus());
            predicates.add(cb.equal(root.get("status"), orderStatusEnum));
        }
        if (orderRequestDTO.getOrderDate() != null){
//            String  date = new SimpleDateFormat("yyyy-MM-dd").format(orderRequestDTO.getOrderDate());
//            Date dateFormated = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Expression<Date> convertFunction = cb.function("DATE", Date.class, root.get("orderDate"));
            predicates.add(cb.equal(convertFunction, orderRequestDTO.getOrderDate()));
        }
        TypedQuery<Orders> query = entityManager.createQuery(cq.select(root).distinct(true)
                .where(cb.and(predicates.toArray(new Predicate[]{}))));

        orders = query.getResultList();

        return orderMapper.toResponseOrderList(orders);
    }
}

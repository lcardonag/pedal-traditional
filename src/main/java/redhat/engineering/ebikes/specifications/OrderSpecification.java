package redhat.engineering.ebikes.specifications;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import redhat.engineering.ebikes.entities.Order;
import redhat.engineering.ebikes.entities.Service_User;

public class OrderSpecification {
    public static Specification<Order> orderHasCustomerId(Long userId) {
        return (root, query, criteriaBuilder) -> {

            Join<Order, Service_User> customerOrder = root.join("customer");

            return criteriaBuilder.equal(customerOrder.get("fullname"), userId);
        };
    }
}

package jjgg.bnymellondemo;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
@Repository
public interface ComplaintRepository extends MongoRepository<Complaint,String>, QuerydslPredicateExecutor<Complaint> {
    Complaint getById(String id);
}

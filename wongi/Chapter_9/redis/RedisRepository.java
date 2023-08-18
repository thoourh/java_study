package dev.thoourh.producer.repository;

import dev.thoourh.producer.model.JobProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RedisRepository extends Crudrepository<JobProcess, String> {

}

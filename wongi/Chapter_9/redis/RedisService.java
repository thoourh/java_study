package dev.thoourh.producer.service;

import dev.thoourh.producer.model.JobProcess;
import dev.thoourh.producer.repository.RedisRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static jdk.incubator.vector.VectorOperators.NOT;

@Service
public class RedisService {
     private final RedisRepository redisRepository;

    public RedisService(
            @Autowired RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    public JobProcess retrieveJob(String jobId){
        Optional<JobProcess> jobProcess = this.redisRepository.findById(jobId);
        if (jobProcess.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return jobProcess.get();
    }
}

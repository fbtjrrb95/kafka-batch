package com.example.demodbcrud.repository;

import com.example.demodbcrud.dto.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
//public interface MemberRepository extends MongoRepository<Member, Long> {
//    @Query("{name : ?0}")
//    Page<Member> findByName(String name, Pageable pageable);
//}

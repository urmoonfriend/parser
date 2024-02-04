package kz.ds.parser.repository;

import kz.ds.parser.model.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Long> {
}

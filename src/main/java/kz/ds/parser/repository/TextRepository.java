package kz.ds.parser.repository;

import kz.ds.parser.model.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {
}

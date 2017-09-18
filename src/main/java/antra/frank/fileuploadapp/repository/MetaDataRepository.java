package antra.frank.fileuploadapp.repository;

import antra.frank.fileuploadapp.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepository extends JpaRepository<MetaData,Long>{
}

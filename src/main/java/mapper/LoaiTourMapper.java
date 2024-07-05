package mapper;

import com.dichvudulich.models.LoaitourEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoaiTourMapper {
	List<LoaitourEntity> findAll();

	LoaitourEntity findById(long id);

	//
	int deleteById(long id);

	int deleteAll();

	//
	int insert(LoaitourEntity employee);

	//
	int update(LoaitourEntity employee);
}
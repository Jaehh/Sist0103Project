package mycar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mycar.data.MyCarCommentDto;

public interface MyCarCommentDaoInter extends JpaRepository<MyCarCommentDto, Integer>{

	
	//num에 해당하는 댓글 목록
	@Query(value="select * from mycar_comment where num=:num order by idx desc",nativeQuery = true )
	public List<MyCarCommentDto> getMyCarCommentList(@Param("num") Long num);


}

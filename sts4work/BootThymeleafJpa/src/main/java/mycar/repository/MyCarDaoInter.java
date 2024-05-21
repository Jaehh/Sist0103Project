package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import mycar.data.MyCarDto;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long> {

    // 자동차명, 가격, 색상만 수정하는 메서드
    @Modifying //insert,update,delete 뿐 아니라 DDL구문 사용시 반드시 사용
    @Transactional //update, delete할때 표기 해줘야 정상작동
    @Query(value = "update mycar set carname = :carname, carprice = :carprice, carcolor = :carcolor where num = :num", nativeQuery = true)
    public void updateMyCarNoPhoto(@Param("num") Long num, 
                                   @Param("carname") String carname, 
                                   @Param("carprice") int carprice, 
                                   @Param("carcolor") String carcolor);
}

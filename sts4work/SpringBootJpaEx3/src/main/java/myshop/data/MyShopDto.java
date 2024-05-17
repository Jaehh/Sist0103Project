package myshop.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="myshop") //자동으로 myshop 테이블이 mysql에 만들어진다, 변수가 변경될 경우 자동수정 됨
public class MyShopDto {
	
	@Id //각 엔티티를 구별할 수 있는 식별자(시퀀스)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	
	@Column(name="sangname")
	private String sangname;
	
	@Column //이름이 같으면 생략가능
	private String sangprice;
	
	@Column
	private String sangcolor;
	
	@Column
	private String sangipgo;
	
	@CreationTimestamp //엔티티 생성시점의 시간 자동등록
	@Column(updatable = false) //수정시 이 컬럼은 수정하지 않겠다
	private Timestamp writeday;
}

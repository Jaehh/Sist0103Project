package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mycar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyCarDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num;
	
	@Column(name="carname",length=30)
	private String carname;
	
	@Column
	private String carprice;
	
	@Column(length=20)
	private String carcolor;
	
	@Column(length=100)
	private String carphoto;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp writeday;
	
	@Transient //테이블의 컬럼으로 생성되지 않고 객체에서는 사용가능한 변수
	private int commentcount;
	
	@Transient
	private String message;
	
}

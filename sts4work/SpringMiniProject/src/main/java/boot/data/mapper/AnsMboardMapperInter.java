package boot.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class AnsMboardMapperInter {

	public void insertAnwser(AnswerMboardDto dto);
	public List<AnserMboardDto> getAllAnser(String num);
	public AnswerMboardDto getAnwer(String idx);
	public void updateAnswer(AnswerMboardDto dto);
	public void deletAnswer(String idx);
}

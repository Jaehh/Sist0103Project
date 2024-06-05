package boot.data.service;

import java.util.List;

import boot.data.dto.AnswerMboardDto;

public interface AnsMboardServiceInter {

	
	public void insertAnswer(AnswerMboardDto dto);
	public List<AnswerMboardDto> getAllAnswer(String num);
	public AnswerMboardDto getAnswer(String idx);
	public void updateAnswer(AnswerMboardDto dto);
	public void deleteAnswer(String idx);
}
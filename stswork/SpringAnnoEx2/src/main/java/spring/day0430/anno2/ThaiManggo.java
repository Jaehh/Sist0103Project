package spring.day0430.anno2;

import org.springframework.stereotype.Component;

@Component("tManggo")
public class ThaiManggo implements Manggo {

	@Override
	public void writeMangoName() {
		// TODO Auto-generated method stub

		System.out.println("내가 좋아하는 태국 망고!!!");
	}

}

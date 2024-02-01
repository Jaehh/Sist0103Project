package JavaProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import JavaProject_1.UpdateEmpInfo;


public class EmpMain extends JFrame implements ActionListener {

    DefaultTableModel model;
    JTable table;
    JButton btnSearch, btnAdd, btnDel, btnUpdate, btnList;
    JTextField tfSearch;

    EmpListForm empListForm;
    
EmpDbModel dbModel = new EmpDbModel();
	
	ImageDraw draw = new ImageDraw();
	String photoName;
	
	Vector<EmpDto> list;

	

    // 생성자
    public EmpMain() {
        super("인사 관리 시스템"); // 제목을 보냄
        this.setBounds(200, 100, 700, 400);
        initDesign();
        this.setVisible(true);

        // 추가 버튼을 누르면 EmpAddForm 창으로 이동
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmpAddForm();
                setVisible(false);
                
            }
        });
        
     // 추가 버튼을 누르면 EmpUpdateForm 창으로 이동
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new EmpUpdateForm();
                setVisible(false);
                
            }
        });
        

    }



	// 디자인
    public void initDesign() {
    	 JPanel pTop = new JPanel(new FlowLayout());
   	    this.add("North", pTop);

   	// 검색창 및 검색 버튼
   	 tfSearch = new JTextField(15);
   	 tfSearch.setBorder(BorderFactory.createCompoundBorder());
   	 pTop.add(tfSearch);


        // 돋보기 아이콘
        ImageIcon searchIcon = new ImageIcon("C:/Users/user/Desktop/search.png"); // 돋보기 아이콘 주소 다시 넣어야
        // 이미지 크기를 조절할 최종 크기
        int width = 20;
        int height = 20;
        // 이미지를 가져와 크기를 조절한 후 JButton에 설정
        Image image = searchIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        JButton btnSearch = new JButton(resizedIcon);

        btnSearch.setBackground(Color.WHITE);
        btnSearch.addActionListener(this);
        pTop.add(btnSearch);

        // 추가버튼
        btnAdd = new JButton("추가");
        pTop.add(btnAdd);

        // 삭제버튼
        btnDel = new JButton("삭제");
        btnDel.addActionListener(this);
        pTop.add(btnDel);

        // 수정버튼
        btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(this);
        pTop.add(btnUpdate);

        
    	   // this.setLayout(null);

    	    // db로부터 목록부터 얻기
    	    list = dbModel.getAllEmp();

    	    String[] title = { "사원번호", "사원명", "성별", "부서", "직책", "주소", "급여", "이메일", "입사일" };
    	    model = new DefaultTableModel(title, 0);
    	    table = new JTable(model);
    	    JScrollPane js = new JScrollPane(table);
    	    js.setBounds(50, 50, 500, 270);
    	    this.add(js);

    	    // 이미지 위치
    	   // draw.setBounds(520, 50, 160, 220);
    	    //this.add(draw);

    	    // 데이터 출력해 주는 메서드
    	    this.datawrite();
		
    	    // 출력된 데이터 이벤트- 익명내부클래스
    	    table.addMouseListener(new MouseAdapter() {
    	        @Override
    	        public void mouseClicked(MouseEvent e) {
    	            // TODO Auto-generated method stub

    	            // 행번호얻기
    	            int row = table.getSelectedRow();

    	            // list에서 row에 해당하는 dto를 꺼내서 거기에서 이미지명을 얻는다
    	            photoName = list.get(row).getPhoto();

    	            // 이미지나오게하는 메서드 호출
    	            draw.repaint();
    	            super.mouseClicked(e);
    	        }

    	    });


        
    }
    
  //데이터 출력해 주는 메서드
  		public void datawrite() {
  			//테이블 기존 데이터 삭제
  			model.setRowCount(0);
  			
  			//테이블에 데이터 추가하기
  			for(EmpDto dto:list) {
  				Vector<String> data = new Vector<String>();
  				data.add(dto.getNum());
  				data.add(dto.getName());
  				data.add(dto.getGender());
  				data.add(dto.getDept());
  				data.add(dto.getPosition());
  				data.add(dto.getAddr());
  				data.add(dto.getPay());
  				data.add(dto.getEmail());
  				//data.add(String.valueOf(dto.getImpsaday()));
  				
  				//테이블 모델에 추가
  				model.addRow(data);
  			}
  		}
 
  		//내부클래스
		class ImageDraw extends Canvas{
			
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				
				if(photoName!=null) {
					Image image = new ImageIcon(photoName).getImage();
					g.drawImage(image, 0, 0, 160, 200, this);
				}
			}
		}
		
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        

        if (ob == btnAdd) {
            EmpAddForm add = new EmpAddForm();
        } else if (ob == btnDel) {
            // 선택된 행의 인덱스 가져오기
            int selectedRowIndex = table.getSelectedRow();

            // 선택된 행이 없으면 메시지 출력 후 종료
            if (selectedRowIndex == -1) {
                JOptionPane.showMessageDialog(EmpMain.this, "삭제할 행을 선택하세요.", "알림", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 선택된 행의 데이터 가져오기
            String num = (String) table.getValueAt(selectedRowIndex, 0);

            // 삭제 전 확인 대화상자
            int option = JOptionPane.showConfirmDialog(EmpMain.this, "정말로 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);

            
            if (option == JOptionPane.YES_OPTION) {
                // 별도의 스레드에서 삭제 작업 실행
                new Thread(() -> {
                    // 삭제할 사원의 EmpDto 생성
                    EmpDto empToDelete = new EmpDto();
                    empToDelete.setNum(num);

                    // 데이터베이스에서 삭제
                    dbModel.deletEmp(empToDelete);

                 // 작업 완료 후 UI 갱신은 EDT에서 실행
                    SwingUtilities.invokeLater(() -> {
                        // 임의의 조건을 통해 데이터가 변경되었을 때에만 갱신
           
                            // 삭제 후 테이블 모델 갱신
                            datawrite();

                            // 테이블에서 선택 해제
                            table.clearSelection();
                    });
               }).start();
            }
        }
        

        else if (ob == btnUpdate) {
        	
            int selectedRowIndex = table.getSelectedRow();

            if (selectedRowIndex == -1) {
                // 선택된 행이 없으면 알림을 띄우고 종료
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(EmpMain.this, "수정할 행을 선택하세요.", "알림", JOptionPane.WARNING_MESSAGE);
                });
                
                return;
            }

            // 선택된 행의 데이터 가져오기
            EmpDto selectedEmp = list.get(selectedRowIndex);

            // 별도의 스레드에서 수정 작업 실행
            new Thread(() -> {
                try {
                    EmpDto empToUpdate = new EmpDto();
                    empToUpdate.setNum(selectedEmp.getNum());

                    EmpDto updatedData = dbModel.updateEmp(empToUpdate);

                    SwingUtilities.invokeLater(() -> {
                        try {
                            if (updatedData != null) {
                                EmpUpdateForm EmpUpdateForm = new EmpUpdateForm(updatedData);
                                EmpUpdateForm.setVisible(true);
                                //setVisible(false);  // 이 부분이 메인 페이지를 숨기는 부분
                                datawrite();
                            } else {
                                // 처리할 내용이 없을 경우
                            }
                        } catch (Exception exception) {
                            // Handle exceptions appropriately
                            exception.printStackTrace();
                        }
                    });
                } catch (Exception exception) {
                    // Handle exceptions appropriately
                    exception.printStackTrace();
                }
            }).start();
        }



         else if (ob == btnList) {
           // System.out.println("list");
             EmpListForm listForm = new EmpListForm();
        } else if(ob ==btnSearch) {
        	// 이름으로 검색하기
            String searchName = tfSearch.getText();

            // 이름이 비어있으면 모든 데이터를 표시
            if (searchName.isEmpty()) {
                datawrite();
            } else {
            	new Thread(() -> {
                // 이름으로 검색된 결과만 표시
                searchByName(searchName);
            	}).start();
    }
        }
        
        }

    
    private void searchByName(String name) {
        // 검색된 데이터 가져오기
        Vector<EmpDto> searchResult = dbModel.searchEmp(name);

        // 테이블 모델 초기화
        model.setRowCount(0);

        // EDT에서 UI 업데이트 수행
        SwingUtilities.invokeLater(() -> {
            if (searchResult.isEmpty()) {
                // 검색 결과가 없을 때 메시지 표시 또는 다른 처리 수행
                JOptionPane.showMessageDialog(EmpMain.this, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // 테이블에 데이터 추가하기
                for (EmpDto dto : searchResult) {
                    Vector<String> data = new Vector<String>();
                    data.add(dto.getNum());
                    data.add(dto.getName());
                    data.add(dto.getGender());
                    data.add(dto.getDept());
                    data.add(dto.getPosition());
                    data.add(dto.getAddr());
                    data.add(dto.getPay());
                    data.add(dto.getEmail());

                    // 테이블 모델에 추가
                    model.addRow(data);
                }
            }
        });
    }





    public static void main(String[] args) {
        new EmpMain();
   
    }
}

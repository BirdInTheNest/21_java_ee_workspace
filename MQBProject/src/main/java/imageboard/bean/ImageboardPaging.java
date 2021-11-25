package imageboard.bean;

import lombok.Data;

@Data
public class ImageboardPaging {
	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][다음] - 3 [startPage][~][endPage]
	private int pageSize; //1페이지당 3개씩
	private int totalA; //총글수
	private StringBuffer pagingHTML; //StringBuffer 편집 가능
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA + pageSize - 1) / pageSize; //총페이지수 = (총글수+2)/3

		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1; //[4][5][6] 현재페이지 5일 때, (5-1)/3 *3 + 1 = 4
		int endPage = startPage + pageBlock - 1; //4 + 3-1
		if(endPage > totalP) endPage = totalP; //[7][8]에서 총페이지수 8이 끝페이지수 9보다 작으면, 끝페이지수 8이 총페이지수가 된다
		
		//이전
		if(startPage > pageBlock)
			pagingHTML.append("<span id='paging' onclick='imageboardPaging("+ (startPage-1) +")'>[이전]</span>");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("[ <span id='currentPaging' onclick='imageboardPaging("+ i +")'>"+ i +"</span> ]");
			}else {
				pagingHTML.append("[ <span id='paging' onclick='imageboardPaging("+ i +")'>"+ i +"</span> ]");
			}
		}//for
		
		//다음
		if(endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='imageboardPaging("+ (endPage+1) +")'>[다음]</span>");
			
	}
}

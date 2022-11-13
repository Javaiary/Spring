package kr.co.heart.domain;

import static java.util.Objects.requireNonNullElse;
import static java.lang.Math.*;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchItem {

	public static final Integer DEFAULT_PAGE_SIZE = 10;
	public static final Integer MIN_PAGE_SIZE = 5;
	public static final Integer MAX_PAGE_SIZE = 50;


	private Integer page = 1;
	private Integer pageSize = DEFAULT_PAGE_SIZE;
	private String option = "";
	private String keyword = "";
	private Integer offset;

	public SearchItem(Integer page, Integer pageSize) {
		this(page, pageSize, "", "");
	}
	
	public SearchItem(Integer page, Integer pageSize, String option, String keyword) {
//		super();
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
	}
	
	public String getQueryString() {
		return getQueryString(page);
	}
	
	// ?page=10&pageSize=10&option=A&keyword=title
	// 쿼리스트링 생성 메소드 
	public String getQueryString(Integer page) {
		return UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("pageSize", pageSize)
				.queryParam("option", option)
				.queryParam("keyword", keyword)
				.build().toString();
	}
	
	public SearchItem() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	//PAGESIZE SETTER
	public void setPageSize(Integer pageSize) {
		this.pageSize = requireNonNullElse(pageSize, DEFAULT_PAGE_SIZE);
		
		//PAGESIZE가 MIN MAX 사이값을 갖도록(둘중 작은값, 큰값)
		this.pageSize = max(MIN_PAGE_SIZE, min(this.pageSize, MAX_PAGE_SIZE));
	}
;
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getOffset() {
		return (page-1) * pageSize;
	}
//	getOffset으로 값을 주었기 때문에 setter가 필요 없음
//	public void setOffset(Integer offset) {
//		this.offset = offset;
//	}

	@Override
	public String toString() {
		return "SearchItem [page=" + page + ", pageSize=" + pageSize + ", option=" + option + ", keyword=" + keyword
				+ ", offset=" + offset + "]";
	}

}

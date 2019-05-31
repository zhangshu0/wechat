package zss.wechat.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class Page implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -5596084315954282504L;

	//default value
	private static final Integer defaultCurrentPage = 1;
	private static final Integer defaultRecordPerPage = 100;

	private static final Integer maxRecordPerPage = 500;

	private static final Integer maxPageItem = 15;

	/**
	 * 当前页，1基址
	 */
	private Integer currentPage = null;
	/**
	 * 每页记录数
	 */
	private Integer recordPerPage = null;
//	/**
//	 * 总页数
//	 */
//	private Integer totalPage = null;
	/**
	 * 总记录数
	 */
	private Integer totalRecord = null;

	private void initialize()
	{
		this.currentPage = defaultCurrentPage;
		this.recordPerPage = defaultRecordPerPage;
	}

	public Page()
	{
		this.initialize();
	}

	public Page(Integer currentPage, Integer recordPerPage)
	{

		this.setCurrentPage(currentPage);
		this.setRecordPerPage(recordPerPage);
	}
	
	public int getLimitStart()
	{
		return this.getRecordPerPage() * (this.getCurrentPage() - 1);
	}
	
//	public int getLimit()
//	{
//		return this.getRecordPerPage();
//	}
	
	public static Page getDefault()
	{
		return new Page(defaultCurrentPage, defaultRecordPerPage);
	}
	
	public Integer getCurrentPage()
	{
		if(currentPage == null || currentPage <= 0){
			currentPage = defaultCurrentPage;
		}
		return currentPage ;
	}
	public void setCurrentPage(Integer currentPage)
	{
		this.currentPage = (currentPage == null || currentPage <= 0) ? defaultCurrentPage : currentPage;
	}
	public Integer getRecordPerPage()
	{
		return recordPerPage == null ? defaultRecordPerPage : recordPerPage;
	}
	public void setRecordPerPage(Integer recordPerPage)
	{
		if(recordPerPage!=null && recordPerPage > maxRecordPerPage){
			recordPerPage = maxRecordPerPage;
		}

		this.recordPerPage = (recordPerPage == null || recordPerPage <= 0) ? defaultRecordPerPage : recordPerPage;
	}

	public Integer getTotalPage()
	{

		int lastNum = getTotalRecord()%getRecordPerPage();

		if(lastNum == 0){
			return getTotalRecord()/getRecordPerPage();
		}else {
			return getTotalRecord()/getRecordPerPage() + 1;
		}

	}

//	public void setTotalPage(Integer totalPage)
//	{
//		this.totalPage = totalPage;
//	}

	public Integer getTotalRecord()
	{
		if(totalRecord ==null){
			return 0;
		}

		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord)
	{
		this.totalRecord = totalRecord;
		if ((this.getCurrentPage() - 1) * this.getRecordPerPage() >= this.totalRecord)
		{
			this.initialize();
		}
	}

	@Override
	public String toString()
	{
		return this.getCurrentPage() + "/" + this.getRecordPerPage();
	}


	/**
	 * 得到分页菜单item
	 * @return
	 */
	public List<Integer> getPageItems(){

		List<Integer> items = new ArrayList<>();
		if(this.getTotalPage()==null){
			return items;
		}


		//总页数小于等于最大条数
		if(this.getTotalPage()<= maxPageItem){
			for(int i=1;i<=this.getTotalPage();i++){
				items.add(i);
			}
			return items;
		}
		//总页数大于最大条数
		else {
			//当前页是前15条
			if(currentPage<=15){
				for(int i=1;i<=15;i++){
					items.add(i);
				}
			}
			//当前页是后15条
			else if(this.getTotalPage()-currentPage<=15){
				for(int i=this.getTotalPage()-15;i<=this.getTotalPage();i++){
					items.add(i);
				}
			}
			//当前页在中间
			else {
				for(int i=currentPage-7;i<=currentPage+8;i++){
					items.add(i);
				}
			}

			return items;
		}
	}

}

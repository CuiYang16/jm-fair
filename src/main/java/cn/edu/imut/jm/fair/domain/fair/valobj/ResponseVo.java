package cn.edu.imut.jm.fair.domain.fair.valobj;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.infrastructrue.util.AbstractResponse;

public class ResponseVo<E> extends AbstractResponse {

	private List<E> list;
	private Integer val;
	private PageInfo<E> pageInfo;
	private JournalFairShowVo fairShowVo;
	private String msg;

	public JournalFairShowVo getFairShowVo() {
		return fairShowVo;
	}

	public void setFairShowVo(JournalFairShowVo fairShowVo) {
		this.fairShowVo = fairShowVo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public ResponseVo(List<E> list, Integer val) {
		super();
		this.list = list;
		this.val = val;
	}

	public ResponseVo(List<E> list) {
		super();
		this.list = list;
	}

	public ResponseVo(Integer val) {
		super();
		this.val = val;
	}

	public PageInfo<E> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<E> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public ResponseVo(PageInfo<E> pageInfo) {
		super();
		this.pageInfo = pageInfo;
	}

	public ResponseVo(JournalFairShowVo fairShowVo) {
		super();
		this.fairShowVo = fairShowVo;
	}

	public ResponseVo(Integer val, String msg) {
		super();
		this.val = val;
		this.msg = msg;
	}

	public ResponseVo(Integer val, JournalFairShowVo fairShowVo, String msg) {
		super();
		this.val = val;
		this.fairShowVo = fairShowVo;
		this.msg = msg;
	}

	public ResponseVo(String msg) {
		super();
		this.msg = msg;
	}

	public ResponseVo() {
		super();
	}

}

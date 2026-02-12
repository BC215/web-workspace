package kr.co.iei.memo.model.vo;

public class Memo {
	private int memoNo;
	private String memoContent;
	private String memoWriter;
	private String memoDate;
	public Memo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMemoNo() {
		return memoNo;
	}
	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}
	public String getMemoContent() {
		return memoContent;
	}
	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}
	public String getMemoWriter() {
		return memoWriter;
	}
	public void setMemoWriter(String memoWriter) {
		this.memoWriter = memoWriter;
	}
	public String getMemoDate() {
		return memoDate;
	}
	public void setMemoDate(String memoDate) {
		this.memoDate = memoDate;
	}
	@Override
	public String toString() {
		return "Memo [memoNo=" + memoNo + ", memoContent=" + memoContent + ", memoWriter=" + memoWriter + ", memoDate="
				+ memoDate + "]";
	}
	public Memo(int memoNo, String memoContent, String memoWriter, String memoDate) {
		super();
		this.memoNo = memoNo;
		this.memoContent = memoContent;
		this.memoWriter = memoWriter;
		this.memoDate = memoDate;
	}
}

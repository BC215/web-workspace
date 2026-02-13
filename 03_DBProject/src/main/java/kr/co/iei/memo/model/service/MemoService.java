package kr.co.iei.memo.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.co.iei.common.SqlSessionTemplate;
import kr.co.iei.memo.model.dao.MemoDao;
import kr.co.iei.memo.model.vo.Memo;

public class MemoService {

	MemoDao dao;

	public MemoService() {
		super();
		dao = new MemoDao();
	}

	public List<Memo> selectAllMemo() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Memo>list = dao.selectAllMemo(session); 
		session.close();
		return list;
	}
	
	public Memo selectMemo(int memoNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Memo m = dao.selectOneMemo(session, memoNo);
		session.close();
		return m;
	}
	public List<Memo> searchWriter(String memoWriter) {
	    SqlSession session = SqlSessionTemplate.getSqlSession();
	    
	  
	    List<Memo> list = dao.searchWriter(session, memoWriter);	    
	    session.close();	    

	    return list;
	}
}

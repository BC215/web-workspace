package kr.co.iei.memo.model.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession; // 이 인터페이스를 사용해야 합니다.
import kr.co.iei.memo.model.vo.Memo;

public class MemoDao {

    public List<Memo> selectAllMemo(SqlSession session) {

        List<Memo> list = session.selectList("memo.selectAllMemo");
        return list;
    }
    public Memo selectOneMemo(SqlSession session, int memoNo) {
        Memo m = session.selectOne("memo.selectOneMemo", memoNo);
        return m;
    }
    public List<Memo> searchWriter(SqlSession session, String memoWriter) {
		List<Memo> list = session.selectList("memo.searchWriter", memoWriter);
		return  list;
	}
}

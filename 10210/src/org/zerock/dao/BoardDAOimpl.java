package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.zerock.dao.util.MyBatisLoader;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PagingDTO;

public class BoardDAOimpl implements BoardDAO<BoardVO> {
	
	private SqlSessionFactory factory = MyBatisLoader.INSTANCE.getFactory(); 

	@Override
	public int insert(BoardVO vo) {
		int count=0;
		
		try (SqlSession session = factory.openSession()) {

			count = session.insert("org.zerock.dao.BoardMapper.insert", vo);
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	

	@Override
	public BoardVO selectOne(Long key) {
		
		BoardVO vo = null;
		
		try (SqlSession session = factory.openSession()) {

			vo = session.selectOne("org.zerock.dao.BoardMapper.selectOne", key);
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public boolean update(BoardVO vo) {
		int count=0;
		
		try (SqlSession session = factory.openSession()) {

			count = session.update("org.zerock.dao.BoardMapper.updateOne", vo);
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count==1;
	}

	@Override
	public boolean delete(Long key) {
		int count=0;
		try (SqlSession session = factory.openSession()) {

			count = session.delete("org.zerock.dao.BoardMapper.deleteOne", key);
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count==1;
	}

	@Override
	public List<BoardVO> getList(PagingDTO dto) {
		
		List li = null;
		
		try (SqlSession session = factory.openSession()) {

			li = session.selectList("org.zerock.dao.BoardMapper.selectList", dto);
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public int getCount() {
		
		int count=0;
		
		try (SqlSession session = factory.openSession()) {

			count = session.selectOne("org.zerock.dao.BoardMapper.selectCount");
			
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	public static void main(String[] args) throws Exception {
		
		BoardDAO dao = new BoardDAOimpl();
		BoardVO vo = new BoardVO();
//		vo.setBno(1L);
//		vo.setTitle("tlas");
//		vo.setWriter("1234");
//		vo.setContent("aerh");
//		
//		System.out.println(dao.update(vo));
		PagingDTO dto = new PagingDTO();
		dto.setAmount(20);
		dto.setPage(1);
//		System.out.println(dao.getList(dto));
		
//		IntStream.range(11, 222).forEach(i -> {
//			
//			vo.setTitle("title...." + i);
//			vo.setContent("content...." + i);
//			vo.setWriter("user" + i);
//			
//			
//			System.out.println(dao.insert(vo));
//			
//			});

		System.out.println(dao.getList(dto));
		
//		dao.setBno(1);
		
	}

}

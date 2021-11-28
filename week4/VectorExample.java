package week4;

import java.util.*;

public class VectorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목 1", "내용 1", "글쓴이1"));
		list.add(new Board("제목 2", "내용 2", "글쓴이2"));
		list.add(new Board("제목 3", "내용 3", "글쓴이3"));
		list.add(new Board("제목 4", "내용 4", "글쓴이4"));
		list.add(new Board("제목 5", "내용 5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for(int i=0; i <list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "" + board.content + board.writer);
		}
	}

}

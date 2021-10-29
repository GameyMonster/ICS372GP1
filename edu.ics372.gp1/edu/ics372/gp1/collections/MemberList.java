package edu.ics372.gp1.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.ics372.gp1.entities.Member;

/**
 * Memberlist class is use maintain a list of member
 * @author Andy
 *
 */
public class MemberList {
	private List<Member> members = new LinkedList<Member>();
	private static MemberList memberList;

	/**
	 * memberList constructor.
	 */
	private MemberList() {

	}

	/**
	 * create an object if it hasnt created yet.
	 * @return memberList
	 */
	public static MemberList getInstance() {
		if (memberList == null) {
			memberList = new MemberList();
		}
		return memberList;
	}
	
	/**
	 * adding member to the list
	 * @param member
	 * @return true or false.
	 */
	public boolean insertMember(Member member) {
		return members.add(member);
	}
	
	/**
	 * get data and information of a member given their ID
	 * @param memberId
	 * @return member, null if there are no member found
	 */
	public Member getMember(String memberId) {
		Iterator<Member> iterator = members.listIterator();
		while(iterator.hasNext()) {
			Member member = iterator.next();
			if(memberId.equals(member.getId())) {
				return member;
			}
		}
		return null;
	}
	
	/**
	 * @return iterator of a memberList
	 */
	public Iterator<Member> getMembers(){
		return members.listIterator();
	}
	
	/**
	 * remove member from the list given their ID
	 * @param memberId
	 * @return true if successful, false if not
	 */
	public boolean removeMember(String memberId) {
		Iterator<Member> iterator = members.listIterator();
		while(iterator.hasNext()) {
			String memberId1 = iterator.next().getId();
			if(memberId.equals(memberId1)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * check a member's membership status given their Id
	 * @param memberId
	 * @return true if is a member, false if not.
	 */
	public boolean isMember(String memberId) {
		Iterator<Member> iterator = members.listIterator();
		while(iterator.hasNext()) {
			Member member = iterator.next();
			if(memberId.equals(member.getId())) {
				return member.isMember();
			}
		}
		return false;
	}
}


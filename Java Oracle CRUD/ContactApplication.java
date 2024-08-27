package j20240826.contact;

import java.util.List;

public class ContactApplication {
	public static void main(String[] args) {
		ContactService contactService = new ContactService();
		
		// 모든 연락처 조회
		List<ContactVO> contactList = contactService.contactList();
		System.out.println(contactList);
		System.out.println("--------------------");
		
		// 길동이 조회
		ContactVO searched1 = contactService.getContactByName("길동이");
		System.out.println(searched1);
		ContactVO searched2 = contactService.getContactByName("영심이");
		System.out.println(searched2);
		
		// 연락처 등록
		/*
		contactService.contactRegister(new ContactVO(4, "상길이", "01010980", "1999onell"));
		;
		ContactVO searched3 = contactService.getContactByName("상길이");
		System.out.println(searched3);
		*/
		// 연락처 삭제
		contactService.contactRemove("상길이");
		
		System.out.println(contactService.contactList());
		
		// 연락처 수정
		ContactVO father = new ContactVO(0, "아버지", "010111", "father@sdf");
		contactService.contactModify(father);
	}
}

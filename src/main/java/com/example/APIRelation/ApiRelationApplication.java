package com.example.APIRelation;

import com.example.APIRelation.dao.CourseDao;
import com.example.APIRelation.dao.StudentDao;
import com.example.APIRelation.dao.TeacherDao;
import com.example.APIRelation.dao.TeacherDetailDao;
import com.example.APIRelation.entity.Course;
import com.example.APIRelation.entity.Student;
import com.example.APIRelation.entity.Teacher;
import com.example.APIRelation.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ApiRelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRelationApplication.class, args);}

		@Bean
		public CommandLineRunner commandLineRunner (TeacherDao teacherDao, TeacherDetailDao teacherDetailDao, CourseDao courseDao, StudentDao studentDao){
			return runner -> {
				//createTeacher(teacherDao);
				//findTeacher(teacherDao);
				//deleteTeacher( teacherDao);
				//createcourse(teacherDao,courseDao);
				//findTeacherByIdJoinFetch(teacherDao,12);
				//createCourseAndStudent(courseDao, studentDao);
				//findCourseAndStudent(courseDao,8);
				findStudentAndCourse(studentDao,7);
			};
		}
		public void findStudentAndCourse(StudentDao studentDao,int id){
			Student s1=studentDao.findStudentAndCourse(id);

			System.out.println("Info Student: ");
			System.out.println(s1);
			System.out.println("Info Course: ");
			System.out.println(s1.getCourses());
			System.out.println("Done!");
		}
		public void findCourseAndStudent(CourseDao courseDao,int id){
			Course c1=courseDao.findCourseAndStudent(id);

			System.out.println("Info course: ");
			System.out.println(c1);
			System.out.println("Info students: ");
			System.out.println(c1.getStudents());
			System.out.println("Done!");
		}
		public void createCourseAndStudent(CourseDao courseDao,StudentDao studentDao){
			Course c1=new Course();
			c1.setDescription("Khoa lap trnh mang");

			Student s1=new Student();
			s1.setEmail("thanhtin@gmail.com");
			s1.setFirstName("Nguyen");
			s1.setLastName("Tin");

			Student s2=new Student();
			s2.setEmail("kieuquy@gmail.com");
			s2.setFirstName("Kieu");
			s2.setLastName("Quy");

			c1.addStudent(s1);
			c1.addStudent(s2);

			courseDao.save(c1);
		}
		public void findTeacherByIdJoinFetch(TeacherDao teacherDao, int id) {
			Teacher teacher1=teacherDao.findTeacherByIdJoinFetch(id);
			System.out.println("Info Techer: ");
			System.out.println(teacher1);
			System.out.println("Course: ");
			//System.out.println(teacher1.getCourseList());
		}
		public void createcourse(TeacherDao teacherDao, CourseDao courseDao) {
			Teacher teacher = new Teacher();
			teacher.setFirstName("Nguyen Vien");
			teacher.setLastName("Dong");
			teacher.setEmail("hihiheheh@gmail.com");

			TeacherDetail teacherDetail = new TeacherDetail();
			teacherDetail.setPhoneNumber("0795743429");
			teacherDetail.setAddress("BinhDinh-TuyPhuoc");
			teacherDetail.setGender(true);
			teacherDetail.setYoutubeChannel("@VienDong");
			teacher.setTeacherDetail(teacherDetail);

			Course c1=new Course("Spring Hibernate",null,null);
			Course c2=new Course("React Fullstack",null,null);

			teacher.addCourse(c1);
			teacher.addCourse(c2);

			System.out.println("Update teacher...");
			teacherDao.update(teacher);
			System.out.println("Done!");
		}
		public void createTeacher (TeacherDao teacherDao){
			Teacher teacher = new Teacher();
			teacher.setFirstName("Nguyen Thanh");
			teacher.setLastName("Tin");
			teacher.setEmail("thanhtin@gmail.com");

			TeacherDetail teacherDetail = new TeacherDetail();
			teacherDetail.setPhoneNumber("0795743429");
			teacherDetail.setAddress("SaiGon-HCM");
			teacherDetail.setGender(true);
			teacherDetail.setYoutubeChannel("@ThanhTin");
			teacher.setTeacherDetail(teacherDetail);
			teacherDao.saveTeacher(teacher);
			System.out.println("Save teacher...." + teacher.toString());
			System.out.println("Done!!!");
		}
		public void findTeacher (TeacherDao teacherDao){
		int id;
		System.out.println("Nhap id: ");
		Scanner scanner = new Scanner(System.in);
		id = scanner.nextInt();
			Teacher teacher = teacherDao.getTeacher(id);
			System.out.println("Teacher: "+teacher);
			System.out.println("TeacherDetail: "+teacher.getTeacherDetail());
		}
		public void deleteTeacher (TeacherDao teacherDao){
			int id;
			System.out.println("Nhap id: ");
			Scanner scanner = new Scanner(System.in);
			id = scanner.nextInt();
			Teacher teacher = teacherDao.getTeacher(id);
			teacherDao.deleteTeacher(id);
		}
	}

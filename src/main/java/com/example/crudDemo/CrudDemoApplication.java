package com.example.crudDemo;

import com.example.crudDemo.Dao.AppDAO;
import com.example.crudDemo.Dao.AppDAOImpl;
import com.example.crudDemo.Entity.Instructor;
import com.example.crudDemo.Entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			appDAO.deleteById(2);
			findInstructorDetail(appDAO);
		};
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail=appDAO.findInstructorDetailById(1);
		System.out.print(instructorDetail);
		System.out.print(instructorDetail.getInstructor());
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor instructor=appDAO.findInstructorById(theId);
		System.out.print(instructor);
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor= new Instructor("Chaitanya", "Thakur","chaitanyacrk03@gmail.com");
//		InstructorDetail instructorDetail=new InstructorDetail(
//				"https://www.youtube.com/channel/UCpNf11iZf-rpQ1PC5n-vXNg",
//				"Coding"
//		);
//		tempInstructor.setInstructorDetail(instructorDetail);
		Instructor tempInstructor= new Instructor("Eren", "Yeager","erenyeager@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail(
				"Attack on Titan",
				"Genocide"
		);
		tempInstructor.setInstructorDetail(instructorDetail);
		System.out.print("Saving Instructor: " + tempInstructor);
		// once we save the tempInstructor then instructor details will also be saved automatically because
		// we set cascading type =all in the
		appDAO.save(tempInstructor);
		System.out.print("Done");

	}
}
